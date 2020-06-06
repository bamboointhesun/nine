package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.ApplyActivity;
import com.sunny.service.ass.ApplyListService;
import com.sunny.utils.BaseService;

@Service
public class ApplyListServiceImpl extends BaseService implements ApplyListService {

	@Override
	public List<ApplyActivity> showAllApplys() {
		List<ApplyActivity> applys = applyActivityMapperImpl.selectAllApplys();
		return applys;
	}

	@Override
	public List<ApplyActivity> showSomeApplys(String title) {
		List<ApplyActivity> list = applyActivityMapperImpl.selectByActivityName(title);
		return list;
	}

}
