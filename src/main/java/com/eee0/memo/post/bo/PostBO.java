package com.eee0.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eee0.memo.common.FileManagerService;
import com.eee0.memo.post.dao.PostDAO;
import com.eee0.memo.post.model.Post;

@Service
public class PostBO {
	
	@Autowired PostDAO postDAO;
	
	public int addPost(int userId, String title, String content, MultipartFile file) {
		
		// 파일을 저장한다.
		// 해당 파일을 외부에서 접근할수 있는 경로를 만들어서 dao로 전달한다.
		String imagePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, title, content, imagePath);
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
