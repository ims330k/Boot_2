package com.iu.b2.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity	
@Table(name = "memberFiles")
//@SequenceGenerator(sequenceName = "file_seq" ,name = "file")
public class MemberFilesVO {	
	//entity maneger의 관리대상으로 넘겨주기 위해서 어노테이션 지정

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file")
	private int fnum;
	//fnum을 만드는데 어떻게 만들거냐? @GeneratedValue
	
	//private String id;
	
	private String fname;
	private String oname;
	@OneToOne
	@JoinColumn(name = "id")
	private MemberVO memberVO;
}
