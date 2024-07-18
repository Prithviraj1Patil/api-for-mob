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
@Table(name = "mst_field_config_master")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FieldConfigMaster {

	@Id
	@SequenceGenerator(name="mst_field_config_master_seq",sequenceName="mst_field_config_master_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mst_field_config_master_seq")
	@Column(name = "fcm_id",columnDefinition="bigint")
	private Long fcmId;
	
	@Column(name = "is_ative",columnDefinition="char")
	private Character isActive;
	
	@Column(name = "created_by",columnDefinition="bigint")
	private Long createdBy;
	
	@Column(name = "created_date",columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private Date createdDate;
	
	@Column(name = "fcm_display_order",columnDefinition="bigint")
	private Long fcmDisplayOrder;
	
	@Column(name = "fcm_field_label",columnDefinition="text")
	private String fcmFieldLabel;
	
	@Column(name = "fcm_field_label_mr",columnDefinition="text")
	private String fcmFieldLabelMr;
	
	@Column(name = "fcm_field_value",columnDefinition="text")
	private String fcmFieldValue;
	
	@Column(name = "is_mandatory",columnDefinition="char")
	private Character isMandatory;
	
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name = "fcm_fm_id", referencedColumnName ="fm_id",columnDefinition="bigint") 
	  private FieldMaster fcmFmId;
	  
	  @Column(name = "fcm_max_length",columnDefinition="bigint")
	  private Long fcmMaxLength;
	  
	  @Column(name = "fcm_regex",columnDefinition="text")
	  private String fcmRegex;
	 
}
