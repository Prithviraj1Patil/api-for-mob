package com.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Questions;
import com.app.Repository.QuestionRepo;
import com.app.Service.QuestionService;
import com.app.dto.QuestionDto;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private QuestionRepo qsRepo;

	@Override
	public List<QuestionDto> getAllQuestions() {
		List<Questions> qsns=qsRepo.findAll();
		List<QuestionDto> qlist=qsns.stream().map(v ->entityToDto(v)).collect(Collectors.toList());
			return qlist;
	}
	
	public QuestionDto entityToDto(Questions vm) {
		QuestionDto vd=modelMapper.map(vm, QuestionDto.class);
		return vd;
	}
	
	public Questions dtoToEntity(QuestionDto vd) {
		Questions vm=modelMapper.map(vd, Questions.class);
		return vm;
	}

}
