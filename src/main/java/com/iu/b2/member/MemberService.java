package com.iu.b2.member;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	//@Autowired
	//private FilePathGenerator filePathGenerator;
	//@Autowired
	//private FileSaver fileSaver;
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		memberVO=memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		return memberVO;
	}
	
	public void memberUpdate(MemberVO memberVO, MultipartFile file)throws Exception{
		MemberFilesVO memberFilesVO=null;
		if(file.getSize()>0) {
			//File file1=filePathGenerator.getUseClassPathResource("upload");
			//String fileName=fileSaver.save(file1, files);
			
			//file저장이후 세팅
			memberVO.setMemberFilesVO(memberFilesVO);
			memberFilesVO.setMemberVO(memberVO);
		}
	}
	
	public void memberDelete(String id)throws Exception{
		memberRepository.deleteById(id);
	}
	public boolean memberIdCheck(String id)throws Exception{
		return memberRepository.existsById(id);
	}
	
	//join으로 가져올거면 이 메서드는 사용 안함
//	public MemberFilesVO memberFiles(MemberVO memberVO)throws Exception{
//		return memberFilesRepository.findById(memberVO.getId());
//	}
	
	public MemberVO memberJoin(MemberVO memberVO, MultipartFile multipartFile) throws Exception{
		memberVO= memberRepository.save(memberVO);
		MemberFilesVO memberFilesVO=new MemberFilesVO();
		memberFilesVO.setMemberVO(memberVO);
		memberFilesVO.setFname(multipartFile.getName());
		memberFilesVO.setOname(multipartFile.getOriginalFilename());
		memberFilesVO.setFnum(0);
		memberFilesVO=memberFilesRepository.save(memberFilesVO);
		//file저장하기해야됨
		//file저장하기해야됨
		//file저장하기해야됨
		//file저장하기해야됨
		//file저장하기해야됨
		//file저장하기해야됨
		return memberVO;
	}
	
	
	
	
}
