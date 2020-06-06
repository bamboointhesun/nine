package com.sunny.controller.ass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.model.system.AssociationJob;
import com.sunny.service.ass.AssociationJobService;
import com.sunny.utils.BaseTime;

@Controller
@RequestMapping("job")
public class AssociationJobController extends BaseTime {

	@Autowired
	private AssociationJobService associationJobServiceImpl;

	@RequestMapping("/list.do")
	public String loginUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		List<AssociationJob> jobs = associationJobServiceImpl.displayJobs();
		model.addAttribute("jobs", jobs);
		return "view/association/job/list";
	}

	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long jobId) {
		associationJobServiceImpl.deleteJobByJobId(jobId);
		// 再去查询一次数据
		return "redirect:/job/list.do";
	}

	@RequestMapping("/updateUI.do")
	public String updateUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			long jobId) {
		AssociationJob job = associationJobServiceImpl.findUpdateObject(jobId);
		model.addAttribute("job", job);
		// 2.跳转页面
		return "view/association/job/update";
	}

	@RequestMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationJob job) {
		job.setUpdateTime(BaseTime.time());
		associationJobServiceImpl.updateJob(job);
		return "redirect:/job/list.do";
	}

	@RequestMapping("/addUI.do")
	public String addUI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		return "view/association/job/add";
	}

	@RequestMapping("/add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model,
			AssociationJob job) {
		job.setCreateTime(BaseTime.time());
		associationJobServiceImpl.addJob(job);
		return "redirect:/job/list.do";
	}

}
