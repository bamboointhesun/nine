package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.ActivityPro;

public interface ActivityProService {

	List<ActivityPro> displayPros();

	void deleteProByProId(long proId);

	ActivityPro findUpdateObject(long proId);

	void updatePro(ActivityPro pro);

	void addPro(ActivityPro pro);
	
}
