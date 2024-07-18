package com.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.SystemConfiguration;
import com.app.Repository.SystemConfigurationRepo;
import com.app.Service.SystemConfigurationService;
import com.app.dto.SystemConfigurationDto;

@Service
public class SystemConfigurationServiceImpl implements SystemConfigurationService {

	@Autowired	
	private SystemConfigurationRepo scRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<SystemConfigurationDto> findAllSc() {
		List<SystemConfiguration> scList=scRepo.findAll();
		return scList.stream().map(s->entityToDto(s)).collect(Collectors.toList());
	}
	
	private SystemConfigurationDto entityToDto(SystemConfiguration sc) {
		return modelMapper.map(sc,SystemConfigurationDto.class);
	}

}
