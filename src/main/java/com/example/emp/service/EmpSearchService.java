package com.example.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Emp;
import com.example.mapper.EmpMapper;
import com.example.util.Pagination;

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
	
	public Map<String, Object> getPage(int pageNo){
		
		return getPage(pageNo, false);
	}
	public Map<String, Object> getPage(int pageNo, boolean withEmp){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectCountemp());
		paging.setItemsPerPage(pageNo);
		
		List<Emp> list = null;
		if(withEmp)
			list = mapper.selectPageWithDept(paging);
		else
			list = mapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("emps", list);
		map.put("paging", paging);

		return map;
	}
	public Emp getByEmpno(int empno){
		
		return getByEmpno(empno, false);
	}
	public Emp getByEmpno(int empno, boolean withEmp){
		Emp emp = null;
		
		if(withEmp)
			emp = mapper.selectByEmpnoWithDept(empno);
		else
			emp = mapper.selectByEmpno(empno);
		
		return emp;
	}
}
