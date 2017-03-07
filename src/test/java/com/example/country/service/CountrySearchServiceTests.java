package com.example.country.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.country.service.CountrySearchService;
import com.example.domain.Country;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountrySearchServiceTests {

	@Autowired
	CountrySearchService service;
	
	@Test
	public void test00_confirm(){
		System.out.println("service = " + service);
	}
	
	@Test
	public void test01_selectAll(){
		List<Country> list = service.getListAll();
		
		for(Country c : list)
			System.out.println(c);
	}
	@Test
	public void test01_selectAll_WithCity(){
		List<Country> list = service.getListAll(true);
		
		for(Country c : list)
			System.out.println(c);
	}
	@Test
	public void test02_getPage(){
		Map<String , Object> map = service.getPage(1);
		System.out.println(map.get("countrys"));
		System.out.println(map.get("paging"));
	}
	@Test
	public void test02_getPage_WithCountry(){
		Map<String , Object> map = service.getPage(1,true);
		
		List<Country>list = (List<Country>)map.get("countrys");
		for(Country c : list)
			System.out.println(c);
		
		System.out.println(map.get("paging"));
	}
	@Test
	public void test03_getByCode(){
		Country counrty = service.getByCode("KOR");
		System.out.println(counrty);
	}
	@Test
	public void test03_getByCode_WithCity(){
		Country country = service.getByCode("KOR", true);
		System.out.println(country);
	}
}
