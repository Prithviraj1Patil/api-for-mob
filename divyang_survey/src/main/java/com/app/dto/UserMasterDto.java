package com.app.dto;

import java.util.Date;

import com.app.Entity.EmployeeMaster;

import lombok.Data;

@Data
public class UserMasterDto {
	
    private Long usmId;
	private Character isActive;
	private Long createdBy;
	private Date createdDate;
	private Long usmElcId;
	private String usmUserName;
	private String usmUserPass;
	private EmployeeMaster usmEpmId;
	private Long usmRomId;

}
