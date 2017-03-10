package com.example.emp.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpSearchServiceTests {

	@Autowired
	EmpSearchService service;
	
	@Test
	public void test00_confirm(){
		System.out.println("service = " + service);
	}
	
	@Test
	public void test01_selectAll(){
		List<Emp> list = service.getList();
		
		for(Emp e : list)
			System.out.println(e);
	}
	
	@Test
	public void test01_selectAllWithDept(){
		List<Emp> list = service.getList(true);
		
		for(Emp e: list)
			System.out.println(e);
	}
	
	@Test
	public void test02_selectPage(){
		Map<String,Object> map = service.getPage(1);
			System.out.println(map.get("emps"));
			System.out.println(map.get("paging"));
	}
	
	@Test
	public void test02_selectPageWithDept(){
		Map<String,Object> map = service.getPage(2, true);
			System.out.println(map.get("emps"));
			System.out.println(map.get("paging"));
	}
	
	@Test
	public void test03_selectByEmpno(){
		Emp emp = service.getByEmpno(7369);
		System.out.println(emp);
	}
	
	@Test
	public void test02_selectByEmpnoWithDept(){
		Emp emp = service.getByEmpno(7369, true);
		System.out.println(emp);
	}
	
	
}
