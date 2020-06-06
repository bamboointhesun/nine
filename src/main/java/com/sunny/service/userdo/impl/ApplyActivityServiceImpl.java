package com.sunny.service.userdo.impl;

import org.springframework.stereotype.Service;

import com.sunny.model.system.ApplyActivity;
import com.sunny.service.userdo.ApplyActivityService;
import com.sunny.utils.BaseService;

@Service
public class ApplyActivityServiceImpl extends BaseService implements ApplyActivityService {

	@Override
	public void submitApplication(ApplyActivity apply) {

		applyActivityMapperImpl.insertSelective(apply);

	}

}
