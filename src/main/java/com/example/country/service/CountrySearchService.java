package com.example.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Country;
import com.example.mapper.CountryMapper;

@Service
public class CountrySearchService {

	@Autowired
	CountryMapper countrymapper;
	
	public List<Country> getListAll(){
		
		return getListAll(false);
	}
	public List<Country> getListAll(boolean withCity){
		List<Country> list = null;
		if(withCity)
			list = countrymapper.selectAllWithCity();
		else
			list = countrymapper.selectAll();
		
		return list;
	}
	
	public Country getByCode(String code){
				
		return getByCode(code, false);
	}
	public Country getByCode(String code , boolean withCity){
		Country country = null;
		
		if(withCity)
			country = countrymapper.selectByCodeWithCity("KOR");
		else
			country = countrymapper.selectByCode("KOR");
		
		return country;
	}
}
