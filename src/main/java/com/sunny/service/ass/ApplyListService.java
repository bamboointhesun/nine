package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.ApplyActivity;

public interface ApplyListService {

	List<ApplyActivity> showAllApplys();
	
	List<ApplyActivity> showSomeApplys(String title);
	
}
