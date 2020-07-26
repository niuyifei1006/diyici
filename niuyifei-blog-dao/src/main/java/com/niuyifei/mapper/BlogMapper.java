package com.niuyifei.mapper;

import java.util.List;
import java.util.Map;

import com.niuyifei.bean.Blog;
import com.niuyifei.bean.Category;

public interface BlogMapper {
	//博文分类列表
	public List<Category> queryCategory();
	//博文列表展示
	public List<Blog> queryBlog(Map<String, Object> map);
	//文章添加
	public void addBlog(Blog blog);
	//修改回显
	public Blog queryBlogById(Integer bid);
	//修改
	public void updateBlog(Blog blog);
	//删除
	public void deleteBlogById(Integer bid);
}