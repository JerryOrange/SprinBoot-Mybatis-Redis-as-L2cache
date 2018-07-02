package com.ncu.jerry.web;

import com.ncu.jerry.entity.Product;
import com.ncu.jerry.service.ProductService;
import com.ncu.jerry.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jiacheng on 2017/7/8.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @GetMapping("/{id}")
    public Product getProductInfo(@PathVariable("id") Long productId) {
        return productService.select(productId);
    }

    @ResponseBody
    @PutMapping("/update")
    public Product updateProductInfo(Product newProduct) {
        Product product = productService.select(newProduct.getId());
        if (product == null) {
            throw new ProductNotFoundException(newProduct.getId());
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productService.update(product);
        return product;
    }
}
