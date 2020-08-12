package com.gura.Spring04;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileTestController {
									//파라미터로 하나만 전송될 때
	@RequestMapping("/upload")		//파일 업로드시 사용하는 MultipartFile 인터페이스
	public String upload(@RequestParam MultipartFile myFile, 
			HttpServletRequest req, @RequestParam String title) {
							
		//원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		//파일의 크기
		long fileSize = myFile.getSize();
		//web-app/upload 폴더까지의 실제 경로(서버 경로)
		String realPath = req.getServletContext().getRealPath("/upload");
		//저장할 파일의 상세 경로                        +       \ 				saveFileName
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		
		if(!upload.exists()) {//만일 디렉토리가 존재하지 않으면 
			upload.mkdir(); //디렉토리 생성
		}
		
		//저장할  파일 명을 구성한다.  >> 파일명이 겹치지 않게하기 위해서 timemillis()
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
		req.setAttribute("title", title);
		//servlet context에 beans 추가하기
		return "upload";
	}
	
	@RequestMapping("/upload2")		
	public String upload2(HttpServletRequest req, @ModelAttribute FileDto dto, MultipartFile myFile ) {
		//FileDto 객체에 있는 MultiPartFile 객체의 참조값 얻어오기 
//		MultipartFile myFile = dto.getMyFile();
		
		//원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		//파일의 크기
		long fileSize = myFile.getSize();
		//web-app/upload 폴더까지의 실제 경로(서버 경로)
		String realPath = req.getServletContext().getRealPath("/upload");
		//저장할 파일의 상세 경로                        +       \ 				saveFileName
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		
		if(!upload.exists()) {//만일 디렉토리가 존재하지 않으면 
			upload.mkdir(); //디렉토리 생성
		}
		
		//저장할  파일 명을 구성한다.  >> 파일명이 겹치지 않게하기 위해서 timemillis()
		String saveFileName = System.currentTimeMillis()+orgFileName;
		
		try {
			//upload 폴더에 파일을 저장한다.
			myFile.transferTo(new File(filePath+saveFileName));
			System.out.println(filePath + saveFileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		
		req.setAttribute("dto", dto);
		//servlet context에 beans 추가하기
		return "upload2";
	}
}
