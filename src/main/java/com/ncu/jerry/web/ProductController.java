package com.ncu.jerry.web;

import com.ncu.jerry.dao.ProductDao;
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

    @GetMapping("/{id}")
    public Product getProductInfo( @PathVariable("id") Long productId) {
        return productService.select(productId);
    }

    @PutMapping("/{id}")
    public Product updateProductInfo(
        @PathVariable("id") Long productId,
        @RequestBody Product newProduct) {
        Product product = productService.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productService.update(product);
        return product;
    }
}
