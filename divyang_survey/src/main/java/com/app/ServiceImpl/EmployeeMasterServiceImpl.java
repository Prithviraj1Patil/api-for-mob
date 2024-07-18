package com.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.EmployeeMaster;
import com.app.Repository.EmployeeMasterRepo;
import com.app.Service.EmployeeMasterService;
import com.app.dto.EmployeeMasterDto;

@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeMasterRepo emRepo;

	@Override
	public List<EmployeeMasterDto> getAllEmployee() {
		List<EmployeeMaster> emList= emRepo.findAll();
		List<EmployeeMasterDto> eList=emList.stream().map(v ->entityToDto(v)).collect(Collectors.toList());
		return eList;
	}
	
	public EmployeeMasterDto entityToDto(EmployeeMaster vm) {
		EmployeeMasterDto vd=modelMapper.map(vm, EmployeeMasterDto.class);
		return vd;
	}
	
	public EmployeeMaster dtoToEntity(EmployeeMasterDto vd) {
		EmployeeMaster vm=modelMapper.map(vd, EmployeeMaster.class);
		return vm;
	}

}
