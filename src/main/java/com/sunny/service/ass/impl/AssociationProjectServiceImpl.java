package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.AssociationProject;
import com.sunny.service.ass.AssociationProjectService;
import com.sunny.utils.BaseService;

@Service
public class AssociationProjectServiceImpl extends BaseService implements AssociationProjectService {

	@Override
	public List<AssociationProject> displayProjects() {
		List<AssociationProject> projects = associationProjectMapperImpl.selectAllProjects();
		return projects;
	}

	@Override
	public void deleteProjectByProjectId(long projectId) {
		associationProjectMapperImpl.deleteByPrimaryKey(projectId);
	}

	@Override
	public AssociationProject findUpdateObject(long projectId) {
		AssociationProject project = associationProjectMapperImpl.selectByPrimaryKey(projectId);
		return project;
	}

	@Override
	public void updateProject(AssociationProject project) {
		associationProjectMapperImpl.updateByPrimaryKeySelective(project);
	}

	@Override
	public void addProject(AssociationProject project) {
		associationProjectMapperImpl.insertSelective(project);

	}

}
