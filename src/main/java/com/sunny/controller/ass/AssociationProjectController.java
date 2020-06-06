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
import com.sunny.model.system.AssociationProject;
import com.sunny.service.ass.AssociationExternalService;
import com.sunny.service.ass.AssociationProjectService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("project")
public class AssociationProjectController extends BaseTime {

	@Autowired
	private AssociationProjectService associationProjectServiceImpl;
	@Autowired
	private AssociationExternalService associationExternalServiceImpl;
	
	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationProject> projects = associationProjectServiceImpl.displayProjects();
		model.addAttribute("projects", projects);
		return "view/association/project/list";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long projectId) {
		associationProjectServiceImpl.deleteProjectByProjectId(projectId);
		// 再去查询一次数据
		return "redirect:/project/list.do";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long projectId) {
		AssociationProject project = associationProjectServiceImpl.findUpdateObject(projectId);
		List<AssociationExternal> sponsors = associationExternalServiceImpl.displaySponsors();
		model.addAttribute("project", project);
		model.addAttribute("sponsors", sponsors);
		// 2.跳转页面
		return "view/association/project/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationProject project) {
		project.setUpdateTime(BaseTime.time());
		associationProjectServiceImpl.updateProject(project);
		return "redirect:/project/list.do";
	}
	
	
	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationExternal> sponsors = associationExternalServiceImpl.displaySponsors();
		model.addAttribute("sponsors", sponsors);
		return "view/association/project/add";
	}
	
	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationProject project) {
		project.setCreateTime(BaseTime.time());
		associationProjectServiceImpl.addProject(project);
		return "redirect:/project/list.do";
	}
	
	

	
}
