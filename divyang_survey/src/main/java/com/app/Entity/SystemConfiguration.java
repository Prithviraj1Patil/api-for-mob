package com.app.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="tbl_system_configuration")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SystemConfiguration {

	@Id
	@SequenceGenerator(name="tbl_system_configuration_seq",sequenceName="tbl_system_configuration_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tbl_system_configuration_seq")
	@Column(name = "sc_id",columnDefinition="bigint")
	private Long scId;
	
	@Column(name = "is_active",columnDefinition="char")
	private Character isActive;
	
	@Column(name = "created_by",columnDefinition="bigint")
	private Long createdBy;
	
	@Column(name = "created_date",columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private Date createdDate;
	
	@Column(name = "config_type",columnDefinition="text")
	private String configType;
	
	@Column(name = "config_value",columnDefinition="text")
	private String configValue;
	
	@Column(name = "config_value_mr",columnDefinition="text")
	private String configValueMr;
	
	/*
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "sc_fm_id", referencedColumnName =
	 * "fm_id",columnDefinition="bigint") private FieldMaster scFmId;
	 */
}
