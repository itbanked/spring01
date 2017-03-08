package com.example.dept.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Country;
import com.example.domain.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptSearchServiceTests {
	
	@Autowired
	DeptSearchService service;
	
	@Test
	public void test00_confirm(){
		System.out.println("service = " + service);
	}
	
	@Test
	public void test01_getListAll(){
		List<Dept> list = service.getList();
		for(Dept d : list)
			System.out.println(d);
	}
	@Test
	public void test01_getListAllWithEmp(){
		List<Dept> list = service.getList(true);
		for(Dept d : list)
			System.out.println(d);
	}
	
	@Test
	public void test02_getPage(){
		Map<String, Object> map = service.getPage(1);
		System.out.println(map.get("paging"));
		System.out.println(map.get("depts"));
	}
	@Test
	public void test02_getPageWithEmp(){
		Map<String, Object> map = service.getPage(1,true);
		
		List<Dept> list = (List<Dept>)map.get("depts");
		for(Dept d : list)
			System.out.println(d);	
		System.out.println(map.get("paging"));
	}	
	
	@Test
	public void test03_getDeptByDeptno(){
		Dept d = service.getDepByDeptno(10);
			System.out.println(d);
	}
	@Test
	public void test03_getDeptByDeptnoWithEmp(){
		Dept d = service.getDepByDeptno(10, true);
			System.out.println(d);
	}	
	
}
