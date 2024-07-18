package com.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SystemConfigurationDto {

    private Long scId;
	private Character isActive;
	private Long createdBy;
	private Date createdDate;
	private String configType;
	private String configValue;
	private String configValueMr;
}
