package com.example.domain;

import java.math.BigDecimal;

import org.junit.Test;

public class EmpTests {
// mgr, hiredate 테스트
	
	@Test
	public void test01_setmgr(){
		Emp e = new Emp();
//										  30000000000000000000
		BigDecimal sal1 = new BigDecimal("10000000000000000000.0012");
		BigDecimal sal2 = new BigDecimal("20000000000000000000.0012");
		BigDecimal sal = sal1.add(sal2);
		
		e.setSal(sal);
		System.out.println("mgr = " + e.getSal());
		
	}
	
	@Test
	public void test01_toString(){
		Emp e = new Emp();
		e.setEmpno(1000);
		e.setEname("홍길동");
		
		System.out.println(e);
	}
	
}
