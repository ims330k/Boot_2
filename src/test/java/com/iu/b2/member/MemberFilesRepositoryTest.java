package com.iu.b2.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberFilesRepositoryTest {

	@Autowired
	private MemberFilesRepository memberFiles;
	@Autowired
	private MemberRepository memberRepository;
//	//@Test
	void test() throws Exception {
		List<MemberFilesVO> ar=memberFiles.findAll();

//		for(MemberFilesVO memberFilesVO:ar) {
//			System.out.println(memberFilesVO.getFname());
//		}
//		Optional<MemberFilesVO> opt=memberFiles.findById(1);
//		Optional<MemberFilesVO> opt2=memberFiles.findById(1);
//		MemberFilesVO memfile=opt.get();
//		MemberFilesVO memfile2=opt2.get();
//		System.out.println(memfile==memfile2);
//		MemberFilesVO memberFilesVO=new MemberFilesVO();
//		memberFilesVO.setId("admin");
//		memberFilesVO.setFname("admin.jpg");
//		memberFilesVO.setOname("admin.jpg");
//		memberFiles.save(memberFilesVO);
		
//		MemberFilesVO memfiles=memberFiles.findByFnum(1);
//		System.out.println("memfiles.getFnum() : "+memfiles.getFnum());
//		System.out.println(memfiles.getFname());
		//List<MemberFilesVO> arr=memberFiles.findById("bb");
		
//		for(MemberFilesVO memberFiles:arr) {
//			System.out.println("---");
//			System.out.println("memberFiles.getId() : "+memberFiles.getId());
//			System.out.println("memberFiles.getFname() : "+memberFiles.getFname());
//		}
	}
	
	//@Test
	public void selectTest()throws Exception{
		Optional<MemberVO> opt=memberRepository.findById("1q");
		MemberVO memberVO=opt.get();
		System.out.println(memberVO.getName());
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getMemberFilesVO().getMemberVO().getId());
	}
	
	//@Test
	public void selectTest2()throws Exception{
		MemberFilesVO filesVO=memberFiles.findById(8).get();
		
		System.out.println(filesVO.getFname());
		System.out.println(filesVO.getMemberVO().getId());
	}
	
	//@Test
	void save()throws Exception{
		MemberVO memberVO=new MemberVO();
		memberVO.setId("2w");
		memberVO.setEmail("email");
		memberVO.setPw("pw");
		memberVO.setName("nananme");
		
		MemberFilesVO memberFilesVO=new MemberFilesVO();
		memberFilesVO.setFname("fname");
		memberFilesVO.setOname("oname");
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}

	@Test
	void update()throws Exception{
		MemberVO memberVO=new MemberVO();
		memberVO.setId("3w");
		memberVO.setEmail("iu");
		memberVO.setPw("iu");
		
		MemberFilesVO memberFilesVO=new MemberFilesVO();
		memberFilesVO.setFnum(13);
		memberFilesVO.setFname("fname");
		memberFilesVO.setOname("oname");
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}
}
