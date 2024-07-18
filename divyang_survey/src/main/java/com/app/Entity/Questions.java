package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mst_questions")
public class Questions {
	
	@Id
	@SequenceGenerator(name="mst_questions_seq",sequenceName="mst_questions_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mst_questions_seq")
	@Column(name = "qs_id",columnDefinition="bigint")
	private Long qsId;
	
	@Column(name = "qs_name",columnDefinition="text")
	private String qsName;
	
	@Column(name = "qs_op1",columnDefinition="text")
	private String qsOp1;
	
	@Column(name = "qs_op2",columnDefinition="text")
	private String qsOp2;
	
	@Column(name = "qs_op3",columnDefinition="text")
	private String qsOp3;
	
	@Column(name = "qs_op4",columnDefinition="text")
	private String qsOp4;

	public Long getQsId() {
		return qsId;
	}

	public void setQsId(Long qsId) {
		this.qsId = qsId;
	}

	public String getQsName() {
		return qsName;
	}

	public void setQsName(String qsName) {
		this.qsName = qsName;
	}

	public String getQsOp1() {
		return qsOp1;
	}

	public void setQsOp1(String qsOp1) {
		this.qsOp1 = qsOp1;
	}

	public String getQsOp2() {
		return qsOp2;
	}

	public void setQsOp2(String qsOp2) {
		this.qsOp2 = qsOp2;
	}

	public String getQsOp3() {
		return qsOp3;
	}

	public void setQsOp3(String qsOp3) {
		this.qsOp3 = qsOp3;
	}

	public String getQsOp4() {
		return qsOp4;
	}

	public void setQsOp4(String qsOp4) {
		this.qsOp4 = qsOp4;
	}
	
	
	

}
