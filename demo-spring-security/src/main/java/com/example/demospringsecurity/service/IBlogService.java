package com.example.demospringsecurity.service;

import com.example.demospringsecurity.entity.Blog;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/5/15.
 */
public interface IBlogService {
    List<Blog> getBlogs();
    void deleteBlog(long id);
}