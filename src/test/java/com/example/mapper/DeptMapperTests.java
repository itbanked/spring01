package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTests {

	
	@Autowired
	DeptMapper mapper;
	
	@Test
	public void test00_confirm(){
		System.out.println("mapper = " + mapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<Dept> list = mapper.selectAll();
		for(Dept d : list)
			System.out.println(d);
	}
	
	@Test
	public void test01_selectAllWithEmp(){
		List<Dept> list = mapper.selectAllWithEmp();
		for(Dept d : list)
			System.out.println(d);
	}
	
	@Test
	public void test03_selectByDeptno(){
		Dept d = mapper.selectByDeptno(10);
		if(d==null)
			throw new NotFoundRuntimeException("부서정보가 없습니다");
			System.out.println(d);
	}
	
	@Test
	public void test03_selectByDeptnoWithEmp(){
		Dept d = mapper.selectByDeptnoWithEmp(10);
		if(d==null)
			throw new NotFoundRuntimeException("부서정보가 없습니다");
		System.out.println(d);
	}
}
