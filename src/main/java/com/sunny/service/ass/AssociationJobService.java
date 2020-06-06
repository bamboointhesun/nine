package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.AssociationJob;

public interface AssociationJobService {

	void deleteJobByJobId(long JobId);
	
	List<AssociationJob> displayJobs();

	AssociationJob findUpdateObject(long jobId);

	void updateJob(AssociationJob job);

	void addJob(AssociationJob job);
	

}
