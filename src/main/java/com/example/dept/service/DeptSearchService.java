package com.example.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Dept;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@Service
public class DeptSearchService {

	@Autowired
	DeptMapper mapper;
	
	public List<Dept> getList(){
		
		return getList(false);
	}
	public List<Dept> getList(boolean withEmp){
		
		List<Dept> list = null;
		
		if(withEmp)
			list = mapper.selectAllWithEmp();
		else	
			list = mapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo){
	
		return getPage(pageNo, false);
	}
	
	public Map<String, Object> getPage(int pageNo , boolean withEmp){
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectDeptCount());
		paging.setPageNo(pageNo);
		
		List<Dept> list = null;
		if(withEmp)
			list = mapper.selectPageWithEmp(paging);
		else
			list = mapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("paging", paging);
		map.put("depts", list);
		
		return map;
	}
	
	
	public Dept getDepByDeptno(int deptno){
		
		return getDepByDeptno(deptno, false);
	}
	public Dept getDepByDeptno(int deptno, boolean withEmp){
		
		Dept dept = null;
		
		if(withEmp)
			dept = mapper.selectByDeptnoWithEmp(deptno);
		else
			dept = mapper.selectByDeptno(deptno);
		
		return dept;
	}
}
