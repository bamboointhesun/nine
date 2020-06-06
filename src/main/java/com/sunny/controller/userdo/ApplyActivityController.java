package com.sunny.controller.userdo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.ApplyActivity;
import com.sunny.service.userdo.ApplyActivityService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("apply")
public class ApplyActivityController extends BaseTime {

	@Autowired
	private ApplyActivityService ApplyActivityServiceImpl;

	@RequestMapping("/applyUI.do")
	public String applyUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			String proTitle) {
		model.addAttribute("proTitle", proTitle);
		return "view/userdo/applydo";
	}

	@RequestMapping("/apply.do")
	public String submitApplication(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, ApplyActivity apply) {
		apply.setCreateTime(BaseTime.time());
		ApplyActivityServiceImpl.submitApplication(apply);
		return "redirect:/interact/readnews.do";
	}

}
