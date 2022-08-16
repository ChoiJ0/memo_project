package com.eee0.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eee0.memo.post.dao.PostDAO;
import com.eee0.memo.post.model.Post;

@Service
public class PostBO {
	
	@Autowired PostDAO postDAO;
	
	public int addPost(int userId, String title, String content) {
		
		return postDAO.insertPost(userId, title, content);
	}
	
	// userId 가 일치하는 메모 리스트 조회
	public List<Post> getPostList(int userId) {
		return postDAO.selectPostList(userId);
	}
	
	// id 일치하는 메모 조회
	public Post getPost(int id) {
		return postDAO.selectPost(id);
	}
	
	
	
}
