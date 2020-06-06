package com.sunny.controller.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.sunny.model.system.AssociationMember;
import com.sunny.model.system.WebUser;
import com.sunny.service.ass.AssociationMemberService;
import com.sunny.service.system.WebUserService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("web")
public class WebUSerController extends BaseTime {
	@Autowired
	private WebUserService webUserServiceImpl;
	@Autowired
	private AssociationMemberService associationMemberServiceImpl;

	/**
	 * 用于跳转页面到登录空表格
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginUI.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		return "view/web/login";
	}

	/**
	 * 接受前台表单数据， 对比数据库内容进行登录验证
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param webUser
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			WebUser webUser) {
		// 获取参数
		String webLoginame = webUser.getUserLoginame();
		String webPassword = webUser.getUserPassword();
		// 调用业务
		int login = webUserServiceImpl.loginService(webLoginame, webPassword);
		// 跳转页面
		String page = null;
		switch (login) {
		case 1:
			/*
			 * 使用转发，链接不跳转，不和逻辑
			 */
			// page = "forward:/AssociationMember/displayInformation.do"; // 登录成功进主页
			/*
			 * 使用重定向，链接跳转，符合逻辑
			 */
			model.addAttribute("webLoginame", webLoginame);
			page = "redirect:/web/loginSuc.do";
			break;
		case 0:
			page = "redirect:/web/registerUI.do"; // 没有注册去注册
			break;
		case -1:
			page = "redirect:/web/reLogin.do"; // 登录失败重新登
			break;
		}
		return page;
	}

	/**
	 * 用于跳转页面到主页面
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginSuc.do")
	public String loginSuc(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			String webLoginame) {
		String page = null;
		/**
		 * 查询是否是社团成员
		 */
	AssociationMember object = associationMemberServiceImpl.findAObject(webLoginame);
	if (object !=null) {
		model.addAttribute("webLoginame", webLoginame);
		page = "view/web/main";
	}else {
		model.addAttribute("webLoginame", webLoginame);
		page = "view/notmember/main";
	}
		return page;
	}

	/**
	 * 用于跳转页面到登录空表格
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/reLogin.do")
	public String loginDef(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		return "view/web/login";
	}

	/**
	 * 用于跳转页面到注册空表格
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/registerUI.do")
	public String registerUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		return "view/web/register";
	}

	@RequestMapping("/reregisterUI.do")
	public String reregisterUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		return "view/web/reregister";
	}

	/**
	 * 接受前台表单数据， 升级数据库
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param model
	 * @param webUser
	 * @return
	 */
	@RequestMapping("/register.do")
	public String register(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			WebUser webUser) {
		String page = null;
		/**
		 * 判断是否含有该用户
		 */
		if (webUserServiceImpl.findMyInformation(webUser.getUserLoginame()) != null) {
			page = "redirect:/web/reregisterUI.do";
		} else {
			webUser.setCreateTime(BaseTime.time());
			webUserServiceImpl.registerService(webUser);
			page = "view/web/login"; // 注册完毕，跳转登录页面
		}

		return page;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/myInformationUI.do")
	public String myInformationUI(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, String webLoginame) {
		WebUser myInformation = webUserServiceImpl.findMyInformation(webLoginame);
		model.addAttribute("myInformation", myInformation);
		String page = "view/web/myInformation";
		return page;
	}

	@RequestMapping("/doMyInformation.do")
	public String doMyInformation(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model, WebUser webUser,String webLoginame) {
		webUser.setUpdateTime(BaseTime.time());
		webUserServiceImpl.updateMyInformation(webUser);
		model.addAttribute("webLoginame", webLoginame);
		return "redirect:/web/myInformationUI.do";
	}

}
