package com.ncu.jerry.web;

import com.ncu.jerry.entity.Content;
import com.ncu.jerry.service.ContentService;
import com.ncu.jerry.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Test Controller
 *
 * Created by Jiacheng on 2018/7/3.
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @ResponseBody
    @GetMapping("/getProductContent/{contentCategoryId}")
    public String getProductInfo(@PathVariable("contentCategoryId") Long contentCategoryId) {
        List<Content> list = contentService.getContentList(contentCategoryId);
        return JsonUtils.objectToJson(list);
    }
}
