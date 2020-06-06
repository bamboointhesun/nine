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

import com.sunny.model.system.ActivityPro;
import com.sunny.model.system.AssociationProject;
import com.sunny.service.ass.ActivityProService;
import com.sunny.service.ass.AssociationProjectService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("news")
public class ActivityProController extends BaseTime{

	@Autowired
	private ActivityProService activityProServiceImpl;
	@Autowired
	private AssociationProjectService associationProjectServiceImpl;

	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		 List<ActivityPro> pros = activityProServiceImpl.displayPros();
		model.addAttribute("pros", pros);
		return "view/association/news/list";
	}

	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long proId) {
		activityProServiceImpl.deleteProByProId(proId);
		// 再去查询一次数据
		return "redirect:/news/list.do";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long proId) {
		ActivityPro pro = activityProServiceImpl.findUpdateObject(proId);
		model.addAttribute("pro", pro);
		// 2.跳转页面
		return "view/association/news/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			ActivityPro pro) {
		pro.setUpdateTime(BaseTime.time());
		activityProServiceImpl.updatePro(pro);
		return "redirect:/news/list.do";
	}

	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationProject> projects = associationProjectServiceImpl.displayProjects();
		model.addAttribute("projects", projects);
		return "view/association/news/add";
	}

	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			ActivityPro pro) {
		pro.setCreateTime(BaseTime.time());
		activityProServiceImpl.addPro(pro);
		return "redirect:/news/list.do";
	}

}
