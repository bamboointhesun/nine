package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.ActivityPro;
import com.sunny.service.ass.ActivityProService;
import com.sunny.utils.BaseService;

@Service
public class ActivityProServiceImpl extends BaseService implements ActivityProService {

	@Override
	public List<ActivityPro> displayPros() {
		List<ActivityPro> pros = activityProMapperImpl.selectAllPros();
		return pros;
	}

	@Override
	public void deleteProByProId(long proId) {
		activityProMapperImpl.deleteByPrimaryKey(proId);
	}

	@Override
	public ActivityPro findUpdateObject(long proId) {
		ActivityPro pro = activityProMapperImpl.selectByPrimaryKey(proId);
		return pro;
	}

	@Override
	public void updatePro(ActivityPro pro) {
		activityProMapperImpl.updateByPrimaryKeySelective(pro);
	}

	@Override
	public void addPro(ActivityPro pro) {
		activityProMapperImpl.insertSelective(pro);
		
	}

	
	
}
