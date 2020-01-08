package com.iu.b1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.b1.member.MemberFilesVO;

@Component
public class FileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		String filePath=(String)model.get("path");
		MemberFilesVO memberFilesVO=(MemberFilesVO)model.get("memberFiles");
		filePath="static/"+filePath;
		ClassPathResource classPathResource=new ClassPathResource(filePath);
		File file=new File(classPathResource.getFile(), memberFilesVO.getFname());
		
		//파일명이 한글일때 처리방법
		response.setCharacterEncoding("UTF-8");
		
		//파일의 크기(남은시간 알려주기용)
		response.setContentLengthLong(file.length());
		
		//파일을 다운로드할때 인코딩 처리
		String fileName=URLEncoder.encode(memberFilesVO.getOname(), "UTF-8");
		
		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일을 읽어 오는 stream
		FileInputStream fi=new FileInputStream(file);
		
		//파일을 출력 하는 stream
		OutputStream os=response.getOutputStream();
		
		//파일 출력
		FileCopyUtils.copy(fi, os);
		
		//stream close
		os.close();
		fi.close();
	}
}
