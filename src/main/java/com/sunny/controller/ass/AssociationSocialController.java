package com.sunny.controller.ass;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.AssociationSocial;
import com.sunny.service.ass.AssociationSocialService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("social")
public class AssociationSocialController extends BaseTime {

	@Autowired
	private AssociationSocialService associationSocialServiceImpl;
	
	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationSocial> socials = associationSocialServiceImpl.displaySocials();
		model.addAttribute("socials", socials);
		return "view/association/social/list";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long socialId) {
		associationSocialServiceImpl.deleteSocialBySocialId(socialId);
		// 再去查询一次数据
		return "redirect:/social/list.do";
	}

	
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long socialId) {
		AssociationSocial social = associationSocialServiceImpl.findUpdateObject(socialId);
		model.addAttribute("social", social);
		// 2.跳转页面
		return "view/association/social/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationSocial social) {
		social.setUpdateTime(BaseTime.time());
		associationSocialServiceImpl.updateSocial(social);
		return "redirect:/social/list.do";
	}
	
	
	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		return "view/association/social/add";
	}
	
	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationSocial social) {
		social.setCreateTime(BaseTime.time());
		associationSocialServiceImpl.addSocial(social);
		return "redirect:/social/list.do";
	}
	
	

	


}
