package com.niuyifei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuyifei.bean.Blog;
import com.niuyifei.bean.Category;
import com.niuyifei.service.BlogService;

@Controller
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	@RequestMapping("queryCategory")
	public String queryCategory(Model model){
		List<Category> category = blogService.queryCategory();
		model.addAttribute("category", category);
		return "category_list";
	}
	
	//查询分类列表
	@RequestMapping("findCategoryAll")
	@ResponseBody
	public List<Category> findCategory(){
		List<Category> category = blogService.queryCategory();
		return category;
	}
	
	//博文列表
	@RequestMapping("queryBlog")
	public String queryBlog(Integer cid,String likeName,String orders,Model model,
							@RequestParam(defaultValue="1")Integer pageNum){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("orders", orders);
		map.put("likeName", likeName);
		PageHelper.startPage(pageNum, 3);
		List<Blog> list = blogService.queryBlog(map);
		PageInfo<Blog> page = new PageInfo<Blog>(list);
		model.addAttribute("page", page);
		model.addAttribute("cid", cid);
		return "blog_list";
	}
	
	//添加或修改文章
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public boolean saveOrUpdate(Blog blog){
		try {
			if (blog.getBid() !=null) {//修改
				blogService.updateBlog(blog);
			} else {
				blogService.addBlog(blog);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	//回显
	@RequestMapping("queryBlogById")
	public String findById(Integer bid,Model model){
		Blog blog = blogService.queryBlogById(bid);
		model.addAttribute("blog", blog);
		return "au_blog";
	}
	//跳转博文添加页面
	@RequestMapping("toadd")
	public String toadd(Integer cid,Model model){
		Blog blog = new Blog();
		blog.setCid(cid);
		//放到作用域
		model.addAttribute("blog", blog);
		return "au_blog";
	}
	//删除
	@RequestMapping("deleteBlogByid")
	@ResponseBody
	public boolean deleteBlogByid(Integer bid){
		try {
			blogService.deleteBlogById(bid);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
