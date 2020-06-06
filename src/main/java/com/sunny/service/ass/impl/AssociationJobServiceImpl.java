package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.AssociationJob;
import com.sunny.service.ass.AssociationJobService;
import com.sunny.utils.BaseService;

@Service
public class AssociationJobServiceImpl extends BaseService implements AssociationJobService {

	@Override
	public void deleteJobByJobId(long jobId) {
		associationJobMapperImpl.deleteByPrimaryKey(jobId);
	}

	@Override
	public List<AssociationJob> displayJobs() {
		List<AssociationJob> allJobs = associationJobMapperImpl.selectAllJobs();
		return allJobs;
	}

	@Override
	public AssociationJob findUpdateObject(long jobId) {
		AssociationJob job = associationJobMapperImpl.selectByPrimaryKey(jobId);
		return job;
	}


	

	@Override
	public void updateJob(AssociationJob job) {
		associationJobMapperImpl.updateByPrimaryKeySelective(job);
	}

	@Override
	public void addJob(AssociationJob job) {
		associationJobMapperImpl.insertSelective(job);
	}

}
