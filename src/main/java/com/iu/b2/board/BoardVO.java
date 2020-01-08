package com.iu.b2.board;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@MappedSuperclass
public class BoardVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//auto increasement : mysql경우 identity 사용
	private int num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
}
