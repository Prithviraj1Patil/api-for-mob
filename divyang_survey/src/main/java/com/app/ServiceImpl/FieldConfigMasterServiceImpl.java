package com.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.FieldConfigMaster;
import com.app.Repository.FieldConfigMasterRepo;
import com.app.Service.FieldConfigMasterService;
import com.app.dto.FieldConfigMasterDto;

@Service
public class FieldConfigMasterServiceImpl implements FieldConfigMasterService {

	@Autowired
	private FieldConfigMasterRepo fcmRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<FieldConfigMasterDto> findAllFieldConfigs() {
		List<FieldConfigMaster> fcmList=fcmRepo.findAll();
		return fcmList.stream().map(f->entityToDto(f)).collect(Collectors.toList());
	}
	
	public FieldConfigMasterDto entityToDto(FieldConfigMaster fcm) {
		return modelMapper.map(fcm, FieldConfigMasterDto.class);
	}

	@Override
	public List<Object[]> findAllFields() {
		
		return fcmRepo.getallFieldList();
	}

}
