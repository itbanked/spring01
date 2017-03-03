package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {
	
	@Autowired
	CityMapper mapper;
	
	@Test
	public void test01_confirmMapper(){
		System.out.println("mapper = " + mapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<City> city = mapper.selectAll();
		
		for(City c : city)
		System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry(){
		List<City> city = mapper.selectAllWithCountry();
		
		for(City c : city)
			System.out.println(c);
	}

}
