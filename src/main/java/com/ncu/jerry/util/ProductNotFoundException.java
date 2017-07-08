package com.ncu.jerry.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Jiacheng on 2017/7/8.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long productId) {
        super("Couldn't find product '" + productId + "'.");
    }
}
