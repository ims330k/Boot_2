package com.iu.b2.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{	//primarykey 타입

	public MemberVO findByIdAndPw(String id, String pw) throws Exception;
	
}
