package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {
	
	@Autowired
	CityMapper citymapper;
	
	@Autowired
	CountryMapper countrymapper;
	
	@Test
	public void test00_confirmCityMapper(){
		System.out.println("citymapper = " + citymapper);
	}
	
	@Test
	public void test00_confirmCountryMapper(){
		System.out.println("countrymapper = " + countrymapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<City> city = citymapper.selectAll();
		
		for(City c : city)
		System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry(){
		List<City> city = citymapper.selectAllWithCountry();
		
		for(City c : city)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(citymapper.selectTotalCount());
		paging.setPageNo(1000);
		
		List<City> list = citymapper.selectPage(paging);
		
		for(City c : list)
			System.out.println(c);		
	}
	
	@Test
	public void test02_selectPageWithCountry(){
		Pagination paging = new Pagination();
		paging.setTotalItem(citymapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<City> list = citymapper.selectPageWithCountry(paging);
		
		for(City c : list)
			System.out.println(c);	
	}
	
	@Test
	public void test03_selectById(){
		City city = citymapper.selectById(10);
		
//		if(city == null){
//			throw new NotFoundRuntimeException("city 정보가 없습니다.");
//		}
		System.out.println("city = " + city);
	}

	@Test
	public void test03_selectByIdWithCountry(){
		City city = citymapper.selectByIdWithCountry(10);
		
//		if(city == null){
//			throw new NotFoundRuntimeException("city 정보가 없습니다.");
//		}
		System.out.println(city);
	}
	
	@Test
	public void test04_insert(){
		City city = new City();
		city.setName("xxx");
		city.setCountryCode("KOR");
		
		Country country = countrymapper.selectByCode(city.getCountryCode());
		
		if(country == null){
			System.out.println("error = " + "해당 country Code가 없습니다.");
			return;
		}
		
		int cnt = citymapper.insert(city);
		System.out.println(citymapper.selectById(city.getId()));
	}
	
}
