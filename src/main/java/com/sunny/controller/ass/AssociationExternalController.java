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

import com.sunny.model.system.AssociationExternal;
import com.sunny.service.ass.AssociationExternalService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("external")
public class AssociationExternalController extends BaseTime {

	@Autowired
	private AssociationExternalService associationExternalServiceImpl;

	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationExternal> sponsors = associationExternalServiceImpl.displaySponsors();
		model.addAttribute("sponsors", sponsors);
		return "view/association/extern/list";
	}

	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long sponsorId) {
		associationExternalServiceImpl.deleteExternalBySponsorId(sponsorId);
		// 再去查询一次数据
		return "redirect:/external/list.do";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long sponsorId) {
		AssociationExternal sponsor = associationExternalServiceImpl.findUpdateObject(sponsorId);
		model.addAttribute("sponsor", sponsor);
		// 2.跳转页面
		return "view/association/extern/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationExternal sponsor) {
		sponsor.setUpdateTime(BaseTime.time());
		associationExternalServiceImpl.updateExternal(sponsor);
		return "redirect:/external/list.do";
	}

	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		return "view/association/extern/add";
	}

	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationExternal sponsor) {
		sponsor.setCreateTime(BaseTime.time());
		associationExternalServiceImpl.addSponor(sponsor);
		return "redirect:/external/list.do";
	}

}
