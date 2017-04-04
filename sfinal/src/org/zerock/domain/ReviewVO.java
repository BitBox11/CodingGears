package org.zerock.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ReviewVO {
	
	private int rno, menuNo, score;
	private String memberId, review;
	private Date reviewDate;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "ReviewVO [rno=" + rno + ", menuNo=" + menuNo + ", score=" + score + ", memberId=" + memberId
				+ ", review=" + review + ", reviewDate=" + reviewDate + "]";
	}
	
	
	
	
	
}
