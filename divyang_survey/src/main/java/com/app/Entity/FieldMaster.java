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
@Table(name = "mst_field_master")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FieldMaster {
	
	@Id
	@SequenceGenerator(name="mst_field_master_seq",sequenceName="mst_field_master_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mst_field_master_seq")
	@Column(name = "fm_id",columnDefinition="bigint")
	private Long fmId;
	
	@Column(name = "fm_name",columnDefinition="text")
	private String fmName;

}
