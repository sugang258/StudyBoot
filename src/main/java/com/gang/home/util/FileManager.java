package com.gang.home.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager {
	
	public String saveFile(MultipartFile multipartFile, String path) throws IOException {
		
		//1. 중복되지 않은 파일명 생성(UUID, Date)
		String fileName = UUID.randomUUID().toString();
		
		//2. 확장자
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		
		
		//파일명과 확장자 분리
		String ex = multipartFile.getOriginalFilename();
		ex = ex.substring(ex.lastIndexOf("."));
		
		bf.append(ex);
		
		fileName = bf.toString();
		
		//3. File Save
		File file = new File(path,bf.toString());
		
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	    multipartFile.transferTo(file);
		
		
		log.info("fileName : {}",bf.toString());
		
		return fileName;
		
	}

}
