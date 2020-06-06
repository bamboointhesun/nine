package com.sunny.service.userdo;

import java.util.List;

import com.sunny.model.system.Comments;

public interface CommentsService {

	void addComment(Comments com);
	
	List<Comments> findHomeComments(long proId);
	
}
