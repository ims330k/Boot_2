package com.iu.b2.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "members")
public class MemberVO {

	@Id
	@NotEmpty(message = "아이디를 입력하세요")
	private String id;
	@Size(min = 4,max = 10)
	private String pw;
	@Transient
	private String pw2;
	@Column(updatable = false)
	private String name;
	private String email;
	
	//@OneToOne(mappedBy = "join하는 entity에 선언된 자기자신의 멤버변수명")
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL)
	private MemberFilesVO memberFilesVO;
}