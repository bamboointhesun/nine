package com.sunny.controller.ass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.ApplyActivity;
import com.sunny.service.ass.ApplyListService;

@Controller
@RequestMapping("applyList")
public class ApplyListController {

	@Autowired
	private ApplyListService applyListServiceImpl;

	@RequestMapping("/list.do")
	public String applyUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<ApplyActivity> applys = applyListServiceImpl.showAllApplys();
		model.addAttribute("applys", applys);
		return "view/association/apply/list";
	}
	@RequestMapping("/find.do")
	public String selectByActivity(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			String title) {
		List<ApplyActivity> applys = applyListServiceImpl.showSomeApplys(title);
		model.addAttribute("applys", applys);
		return "view/association/apply/list";
	}
	
	

}
