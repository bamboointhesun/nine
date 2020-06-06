package com.sunny.controller.ass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.AssociationJob;
import com.sunny.model.system.AssociationMember;
import com.sunny.service.ass.AssociationJobService;
import com.sunny.service.ass.AssociationMemberService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("member")
public class AssociationMemberController extends BaseTime {

	@Autowired
	private AssociationMemberService associationMemberServiceImpl;
	@Autowired
	private AssociationJobService associationJobServiceImpl;
	
	
	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationMember> members = associationMemberServiceImpl.displayMembers();
		model.addAttribute("members", members);
		return "view/association/member/list";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long memberId) {
		associationMemberServiceImpl.deleteMemberByMemberId(memberId);
		// 再去查询一次数据
		return "redirect:/member/list.do";
	}

	/**
	 * 避免日期类型错误
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long memberId) {
		AssociationMember member = associationMemberServiceImpl.findUpdateObject(memberId);
		model.addAttribute("member", member);
		List<AssociationJob> jobs = associationJobServiceImpl.displayJobs();
		model.addAttribute("jobs", jobs);
		// 2.跳转页面
		return "view/association/member/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationMember member) {
		member.setUpdateTime(BaseTime.time());
		associationMemberServiceImpl.updateMember(member);
		return "redirect:/member/list.do";
	}
	
	
	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationJob> jobs = associationJobServiceImpl.displayJobs();
		model.addAttribute("jobs", jobs);
		return "view/association/member/add";
	}
	
	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationMember member) {
		member.setCreateTime(BaseTime.time());
		associationMemberServiceImpl.addMember(member);
		return "redirect:/member/list.do";
	}
	
	

	
}
