package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.AssociationProject;


public interface AssociationProjectService {

	List<AssociationProject> displayProjects();

	void deleteProjectByProjectId(long projectId);

	AssociationProject findUpdateObject(long projectId);

	void updateProject(AssociationProject project);

	void addProject(AssociationProject project);
	
}
