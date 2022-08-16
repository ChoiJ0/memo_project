package com.eee0.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eee0.memo.post.bo.PostBO;

@RestController
public class PostRestController {
	
	@Autowired PostBO postBO;
	
	// 메모 입력 api
	@PostMapping("/post/create")
	public Map<String, String> memoCreate(
			@RequestParam("title") String Title,
			@RequestParam("content") String content,
			@RequestParam(value="file", required=false) MultipartFile file,	 // 필수 값 제외		
			HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postBO.addPost(userId, Title, content, file);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
//	@PostMapping("/post/update")
//	public Map<String, String> memoUpdate(
//			@RequestParam("title") String title,
//			@RequestParam("content") String content,
//			HttpServletRequest request){
//		
//			HttpSession session = request.getSession();
//			
//			()session.getAttribute("userId");
//			
//			Map<String, String> result = new HashMap<>();
//			
//			return result;
//		
//	}
	
	

}
