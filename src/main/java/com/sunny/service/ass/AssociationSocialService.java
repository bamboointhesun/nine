package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.AssociationSocial;

public interface AssociationSocialService {

	List<AssociationSocial> displaySocials();

	void deleteSocialBySocialId(long socialId);

	AssociationSocial findUpdateObject(long socialId);

	void updateSocial(AssociationSocial social);

	void addSocial(AssociationSocial social);
	
}
