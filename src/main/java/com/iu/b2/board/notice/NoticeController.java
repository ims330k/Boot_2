package com.iu.b2.board.notice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@ModelAttribute
	NoticeVO noticeVO() {
		return new NoticeVO();
	}
	
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		return "notice/noticeWrite";
	}
	
	@PostMapping("noticeWrite")
	public void noticeWrite(NoticeVO noticeVO)throws Exception{
		
	}
	
	@GetMapping("noticeSelect")
	public void noticeSelect(int num)throws Exception{
		Optional<NoticeVO> opt=noticeRepository.findById(num);
		NoticeVO noticeVO=opt.get();
	}
	
}
