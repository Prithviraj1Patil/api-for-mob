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
@Table(name = "tbl_role_master")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RoleMaster {

	@Id
	@SequenceGenerator(name="tbl_role_master_seq",sequenceName="tbl_role_master_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tbl_role_master_seq")
	@Column(name = "rm_id",columnDefinition="bigint")
	private Long rmId;
	
	@Column(name = "rm_name",columnDefinition="text")
	private String rmName;
}
