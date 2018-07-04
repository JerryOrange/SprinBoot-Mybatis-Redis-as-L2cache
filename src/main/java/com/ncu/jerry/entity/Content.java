package com.ncu.jerry.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Content entity
 *
 * Created by Jiacheng on 2018/7/3.
 */
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private long categoryId;
    private String title;
    private String content;
    private Date createDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
