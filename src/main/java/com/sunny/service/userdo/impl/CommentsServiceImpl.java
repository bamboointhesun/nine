package com.sunny.service.userdo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.Comments;
import com.sunny.service.userdo.CommentsService;
import com.sunny.utils.BaseService;

@Service
public class CommentsServiceImpl extends BaseService implements CommentsService {

	@Override
	public void addComment(Comments com) {
		commentsMapperImpl.insertSelective(com);
	}

	@Override
	public List<Comments> findHomeComments(long proNo) {
		List<Comments> comments = commentsMapperImpl.selectCommentsByNewId(proNo);
		return comments;
	}

	
	
}
