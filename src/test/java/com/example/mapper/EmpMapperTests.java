package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.util.Pagination;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {	

	@Autowired
	EmpMapper empmapper;
	
	@Autowired
	DeptMapper deptmapper;
	
	@Test
	public void test01_confirmMapper(){
		System.out.println("empmapper = " + empmapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<Emp> emps = empmapper.selectAll();
		
		for(Emp e : emps)
			System.out.println(e);
	}
	
	@Test
	public void test01_selectAllWithDept(){
		List<Emp> emps = empmapper.selectAllWithDept();
		
		for(Emp e : emps)
			System.out.println(e);
	}
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(empmapper.selectCountemp());
		paging.setPageNo(2);
		List<Emp> emps = empmapper.selectPage(paging);
		
		for(Emp e : emps)
			System.out.println(e);	
	}
	@Test
	public void test02_selectPageWithDept(){
		Pagination paging = new Pagination();
		paging.setTotalItem(empmapper.selectCountemp());
		paging.setPageNo(1);
		List<Emp> emps = empmapper.selectPageWithDept(paging);
		
		for(Emp e : emps)
			System.out.println(e);
	}
	@Test
	public void test03_selectByEmpno(){
		Emp e = empmapper.selectByEmpno(7369);
			System.out.println(e);
	}
	
	@Test
	public void test03_selectAllWithDept(){
		Emp e = empmapper.selectByEmpnoWithDept(7369);
			System.out.println(e);
	}
	
	@Test
	public void test04_insert(){
		Emp emp = new Emp();
		emp.setEname("hongfour");
		emp.setDeptno(40);
		
		Dept dept = deptmapper.selectByDeptno(emp.getDeptno());
		
		if(dept == null){
			System.out.println("error = " + "deptno가 없습니다");
			return;
		}
		
		int cnt = empmapper.insert(emp);
		System.out.println("cnt = " + cnt);
		System.out.println(empmapper.selectByEmpno(emp.getEmpno()));
	}
}
