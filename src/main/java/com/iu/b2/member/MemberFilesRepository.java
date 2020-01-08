package com.iu.b2.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer>{
	//JpaRepository<관리할 대상VO, pk타입>

	//public MemberFilesVO findByFnum(int fnum);	
	//public List<MemberFilesVO> findById(String id)throws Exception;
	
}
