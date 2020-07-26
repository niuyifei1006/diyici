package com.niuyifei.service;

import java.util.List;
import java.util.Map;

import com.niuyifei.bean.Blog;
import com.niuyifei.bean.Category;

public interface BlogService {
	public List<Category> queryCategory();
	//�����б�չʾ
	public List<Blog> queryBlog(Map<String, Object> map);
	//�������
	public void addBlog(Blog blog);
	//�޸Ļ���
	public Blog queryBlogById(Integer bid);
	//�޸�
	public void updateBlog(Blog blog);
	//ɾ��
	public void deleteBlogById(Integer bid);
}
