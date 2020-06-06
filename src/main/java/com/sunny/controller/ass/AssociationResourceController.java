package com.sunny.controller.ass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.AssociationResource;
import com.sunny.service.ass.AssociationResourceService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("resource")
public class AssociationResourceController extends BaseTime {

	@Autowired
	private AssociationResourceService associationResourceServiceImpl; 
	
	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationResource> resources = associationResourceServiceImpl.displayResources();
		model.addAttribute("resources", resources);
		return "view/association/resource/list";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long resourceId) {
		associationResourceServiceImpl.deleteResourceByResourceId(resourceId);
		// 再去查询一次数据
		return "redirect:/resource/list.do";
	}

	
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long resourceId) {
		AssociationResource resource = associationResourceServiceImpl.findUpdateObject(resourceId);
		model.addAttribute("resource", resource);
		// 2.跳转页面
		return "view/association/resource/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationResource resource) {
		resource.setUpdateTime(BaseTime.time());
		associationResourceServiceImpl.updateResource(resource);
		return "redirect:/resource/list.do";
	}
	
	
	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		return "view/association/resource/add";
	}
	
	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationResource resource) {
		resource.setCreateTime(BaseTime.time());
		associationResourceServiceImpl.addResource(resource);
		return "redirect:/resource/list.do";
	}
	
	

	
}
