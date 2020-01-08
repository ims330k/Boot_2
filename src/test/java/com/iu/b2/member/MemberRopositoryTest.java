package com.iu.b2.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

@SpringBootTest
class MemberRopositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	//@Test
	void test() {
		//fail("Not yet implemented");
//		List<MemberVO> ar=memberRepository.findAll();
//		for(MemberVO memberVO:ar) {
//			System.out.println(memberVO.getId());
//		}
//		Optional<MemberVO> opt=memberRepository.findById("iu15");
//		MemberVO memberVO=opt.get();
//		System.out.println(memberVO.getEmail());
//		if (opt.isPresent()) {
//			memberVO=opt.get();
//			System.out.println(memberVO.getEmail());
//		}else {
//			System.out.println("no data");
//		}
		MemberVO memberVO=new MemberVO();
		memberVO.setId("iu3306");
		memberVO.setPw("iu3306");
		memberVO.setEmail("rename");
		memberRepository.save(memberVO);
		//실행은 먼저 조회를 한다. 같은 값이 있는지 없는지.
		//동일한 아이디가 있으면 update, 없으면 insert!!!
		//updqte시 값이 하나 빠지면 null값으로 저장됨. 
	}
	
	//@Test
	public void loginTest()throws Exception{
		MemberVO memberVO=new MemberVO();
		memberVO.setId("1q");
		memberVO.setPw("1q");
		memberVO=memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		System.out.println("test@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getName());
	}
	//@Test
	public void joinTest()throws Exception{
		MemberVO memberVO=new MemberVO();
		MemberVO memberVO2=new MemberVO();
		memberVO.setId("testJoin_id2");
		memberVO.setPw("testJoin_pw");
		memberVO.setName("testJoin_name");
		memberVO.setEmail("testJoin_1@testJoin_1");
		boolean check=false;
		memberVO2=memberRepository.save(memberVO);
		if (memberVO.getId().equals(memberVO2.getId())) {
			check=true;
		}
		assertEquals(true, check);
	}

}
