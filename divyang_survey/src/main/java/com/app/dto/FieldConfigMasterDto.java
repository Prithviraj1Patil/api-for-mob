package com.app.dto;

import java.util.Date;

import com.app.Entity.FieldMaster;

import lombok.Data;

@Data
public class FieldConfigMasterDto {

    private Long fcmId;
	private Character isActive;
	private Long createdBy;
	private Date createdDate;
	private Long fcmDisplayOrder;
	private String fcmFieldLabel;
	private String fcmFieldLabelMr;
	private String fcmFieldValue;
	private Character isMandatory;
	  private FieldMaster fcmFmId;
	  private Long fcmMaxLength;
	  private String fcmRegex;
}
