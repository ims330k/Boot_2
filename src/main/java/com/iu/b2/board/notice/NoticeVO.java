package com.iu.b2.board.notice;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.iu.b2.board.BoardVO;

import lombok.Data;

@Data
@Table(name = "notice")
@Entity
public class NoticeVO extends BoardVO{
//	num	int(11)
//	title	varchar(45)
//	writer	varchar(45)
//	contents	text
//	regDate	date
//	hit	int(11)
	
	/*jpa는 멤버변수가 아옝 없다고 생각한다. 상속을 받았지만 확인을 못한다.
	 * entity매니저가 entity로 선언된 것들만 다룬다.
	 * boardVO에 entity가 없는 상태이니 boardVO에도 @Entity를 선언해주자. > 이걸론 해결x
	 * 쿼리문까진 들어왔는데 where boardVO에서 찾고있다. noticeVO에서 찾아야하는데 다른곳에서 찾는다.
	 * BOARDVOdpek @MappedSuperClass 추가, @Entity는 삭제
	 * 
	 * @Data
		@MappedSuperclass
		public class BoardVO {
	 * 
	 * 참고 : https://victorydntmd.tistory.com/209
	*/
	
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFilesVO> noticeFilesVOs;
	/* fetch = FetchType.LAZY 
	 * 나중에 한다?
	 * findById를 하면 NotieFilesVO를 가져오진 않는다.
	 * 반대로 finesVO를 findbyId하면 join되서 전체를 다 가져온다.
	 * 그래서,
	 * noticeVO에 noticeFilesVO까지 가져오려면 해당 코드를 추가로 작성해준다.
	 * Service클래스에 @Transactional를 붙여준다.
	 * 불러오는 코드는 다른게 아니라. 
	 * 평소에 쓰던 ~filesVO.getFnum() 이런식으로 쓰면 가져오게된다.
	 * */
}
