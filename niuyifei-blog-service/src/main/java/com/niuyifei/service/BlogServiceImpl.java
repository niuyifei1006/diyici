package com.niuyifei.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niuyifei.bean.Blog;
import com.niuyifei.bean.Category;
import com.niuyifei.mapper.BlogMapper;
@Service
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogMapper blogMapper;
	
	public List<Category> queryCategory() {
		// TODO Auto-generated method stub
		return blogMapper.queryCategory();
	}

	public List<Blog> queryBlog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogMapper.queryBlog(map);
	}

	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogMapper.addBlog(blog);
	}

	public Blog queryBlogById(Integer bid) {
		// TODO Auto-generated method stub
		return blogMapper.queryBlogById(bid);
	}

	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogMapper.updateBlog(blog);
	}

	public void deleteBlogById(Integer bid) {
		// TODO Auto-generated method stub
		blogMapper.deleteBlogById(bid);
	}
}
