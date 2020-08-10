package com.gura.Spring04;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileTestController {
									//파라미터로 하나만 전송될 때
	@RequestMapping("/upload")		//파일 업로드시 사용하는 MultipartFile 인터페이스
	public String upload(@RequestParam MultipartFile myFile, 
			HttpServletRequest req) {
							
		//원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		//파일의 크기
		long fileSize = myFile.getSize();
		//web-app/upload 폴더까지의 실제 경로
		String realPath = req.getServletContext().getRealPath("/upload");
		//저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		
		if(!upload.exists()) {//만일 디렉토리가 존재하지 않으면 
			upload.mkdir(); //디렉토리 생성
		}
		
		//저장할  파일 명을 구성한다.
		String saveFileName = System.currentTimeMillis()+orgFileName;
		
		try {
			//upload 폴더에 파일을 저장한다.
			myFile.transferTo(new File(filePath+saveFileName));
			System.out.println(filePath + saveFileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("orgFileName", orgFileName);
		req.setAttribute("saveFileName", saveFileName);
		req.setAttribute("fileSize", fileSize);
		//servlet context에 beans 추가하기
		return "upload";
	}
}
