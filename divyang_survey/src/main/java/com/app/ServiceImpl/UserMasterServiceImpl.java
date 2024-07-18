package com.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.UserMaster;
import com.app.Repository.UserMasterRepo;
import com.app.Service.UserMasterService;
import com.app.dto.UserMasterDto;

@Service
public class UserMasterServiceImpl implements UserMasterService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserMasterRepo umRepo;

	@Override
	public List<UserMasterDto> getAllUsers() {
		List<UserMaster> umList=umRepo.findAll();
		return umList.stream().map(u -> entityToDto(u)).collect(Collectors.toList());
	}
	
	public UserMasterDto entityToDto(UserMaster um) {
		return modelMapper.map(um, UserMasterDto.class);
	}
	
	public UserMaster dtoToEntity(UserMasterDto umd) {
		return modelMapper.map(umd, UserMaster.class);
	}

}
