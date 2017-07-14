package com.ncu.jerry;

import com.ncu.jerry.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

/*
 * 2017-7-14
 * 单元测试步骤：
 * 1、我们首先调用get接口，通过assert语句判断是否得到了预期的对象。此时该product对象会存入redis中。
 * 2、然后我们调用put接口更新该product对象，此时redis缓存会失效。
 * 3、最后我们再次调用get接口，判断是否获取到了新的product对象。如果获取到老的对象，说明缓存失效的代码执行失败，代码存在错误，反之则说明我们代码是OK的。
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //测试类中的注解，来启用test环境下的配置，一键从mysql数据库切换到h2数据库。
@ActiveProfiles(profiles = "test")
public class SpringbootApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate; //Web接口测试的工具类
    @Test
    public void test() {
        long productId = 1;
        Product product = restTemplate.getForObject("http://localhost:" + port + "/product/" + productId, Product.class);
        assertThat(product.getPrice()).isEqualTo(200);
        Product newProduct = new Product();
        long newPrice = new Random().nextLong();
        newProduct.setName("new name");
        newProduct.setPrice(newPrice);
        restTemplate.put("http://localhost:" + port + "/product/" + productId, newProduct);
        Product testProduct = restTemplate.getForObject("http://localhost:" + port + "/product/" + productId, Product.class);
        assertThat(testProduct.getPrice()).isEqualTo(newPrice);
    }
}
