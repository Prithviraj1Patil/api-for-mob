package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "tbl_employee_master")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeMaster {
	
	@Id
	@SequenceGenerator(name="tbl_employee_master_seq",sequenceName="tbl_employee_master_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tbl_employee_master_seq")
	@Column(name = "epm_id",columnDefinition="bigint")
	private Long epmId;
	
	@Column(name = "epm_name",columnDefinition="text")
	private String epmName;
	
	@Column(name = "epm_mobile_no",columnDefinition="bigint")
	private Long epmMobNo;
	
	@Column(name = "epm_email_id",columnDefinition="text")
	private String epmEmailId;
	

}
