package com.app.Service;

import java.util.List;

import com.app.dto.FieldConfigMasterDto;

public interface FieldConfigMasterService {

	List<FieldConfigMasterDto> findAllFieldConfigs();
	
	List<Object[]> findAllFields();
}
