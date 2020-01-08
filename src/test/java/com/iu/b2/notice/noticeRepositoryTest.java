package com.iu.b2.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b2.board.notice.NoticeFilesVO;
import com.iu.b2.board.notice.NoticeRepository;
import com.iu.b2.board.notice.NoticeVO;


@SpringBootTest
@Transactional
class noticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	//@Test
	void test() {
		Optional<NoticeVO> opt=noticeRepository.findById(12);
		NoticeVO noticeVO=opt.get();
		System.out.println("==========================get NoticeVO==========================");
		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getContents());
		for(NoticeFilesVO noticeFilesVO : noticeVO.getNoticeFilesVOs()) {
			System.out.println("noticeFilesVO.getFnum() : "+noticeFilesVO.getFnum());
		}
	}

	@Test
	void test2(){
		
	}
}
