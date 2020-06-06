package com.sunny.controller.visitor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.ActivityPro;
import com.sunny.model.system.Comments;
import com.sunny.service.ass.ActivityProService;
import com.sunny.service.userdo.CommentsService;

@Controller
@RequestMapping("visitor")
public class seeNewsController {
	
	@Autowired
	private ActivityProService activityProServiceImpl;
	@Autowired
	private CommentsService commentsServiceImpl; 
	
	@RequestMapping("/readnews.do")
	public String newsList(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,String name) {
		List<ActivityPro> pros = activityProServiceImpl.displayPros();
		model.addAttribute("pros", pros);
		model.addAttribute("name", name);
		return "view/visitor/newstitles";
	}
	
	@RequestMapping("/detail.do")
	public String newsDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long proId,String name) {
		ActivityPro pro = activityProServiceImpl.findUpdateObject(proId);
		List<Comments> comments = commentsServiceImpl.findHomeComments(proId);
		model.addAttribute("pro", pro);
		model.addAttribute("comments", comments);
		model.addAttribute("name", name);
		return "view/visitor/newsdetail";
	}
	
	@RequestMapping("/comment.do")
	public String comment(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			Comments comment,long proId) {
		commentsServiceImpl.addComment(comment);
		
		ActivityPro pro = activityProServiceImpl.findUpdateObject(proId);
		List<Comments> comments = commentsServiceImpl.findHomeComments(proId);
		model.addAttribute("pro", pro);
		model.addAttribute("comments", comments);
		// model.addAttribute("proId",proNo);
		// return "redirect:/interact/detail.do";
		
		return "view/visitor/newsdetail";
	}

}
