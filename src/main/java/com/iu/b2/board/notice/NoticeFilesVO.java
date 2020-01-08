package com.iu.b2.board.notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "noticeFiles")
@Data
public class NoticeFilesVO {
//	fnum	int(11)
//	num	int(11)
//	fname	varchar(45)
//	oname	varchar(45)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	//private int num; FK는 명시하지 않는다~
	private String  fname;
	private String oname;
	
	@ManyToOne	//앞에 오는건 현재 클래스, 뒤에 오는건 멤버변수
	@JoinColumn(name = "num")
	private NoticeVO noticeVO;
}
