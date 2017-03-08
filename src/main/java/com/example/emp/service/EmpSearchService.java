package com.example.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Emp;
import com.example.mapper.EmpMapper;

@Service
public class EmpSearchService {

	@Autowired
	EmpMapper mapper;
	
	public List<Emp> getList(){
		
		return getList(false);
	}
	public List<Emp> getList(boolean withdept){
		
		List<Emp> list = null;
		
		if(withdept)
			list = mapper.selectAllWithDept();
		else
			list = mapper.selectAll();
		
		return list;
	}
}
