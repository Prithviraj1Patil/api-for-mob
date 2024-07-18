package com.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.FieldMaster;
import com.app.Repository.FieldMasterRepo;
import com.app.Service.FieldMasterService;
import com.app.dto.FieldMasterDto;
@Service
public class FieldMasterServiceImpl implements FieldMasterService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FieldMasterRepo fmRepo;

	@Override
	public List<FieldMasterDto> getAllFieldMasters() {
		List<FieldMaster> fmList=fmRepo.findAll();
		List<FieldMasterDto> fmdList=fmList.stream().map(f-> entityToDto(f)).collect(Collectors.toList());
		return fmdList;
	}
	
	private FieldMasterDto entityToDto(FieldMaster fm) {
		FieldMasterDto fmd=modelMapper.map(fm,FieldMasterDto.class);
		return fmd;
	}

}
