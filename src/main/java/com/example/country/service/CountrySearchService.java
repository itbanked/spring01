package com.example.country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.mapper.CountryMapper;
import com.example.util.Pagination;

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
	
	public Map<String, Object> getPage(int pageNo){
		
		return getPage(pageNo, false);
	}
	
	public Map<String, Object> getPage(int pageNo, boolean withCity){
		Pagination paging = new Pagination();
		paging.setTotalItem(countrymapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Country> list = null;
		if(withCity)
			list = countrymapper.selectPageWithCity(paging);
		else
			list = countrymapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("countrys", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Country getByCode(String code){
				
		return getByCode(code, false);
	}
	public Country getByCode(String code , boolean withCity){
		Country country = null;
		
		if(withCity)
			country = countrymapper.selectByCodeWithCity(code);
		else
			country = countrymapper.selectByCode(code);
		
		if(country == null)
			throw new NotFoundRuntimeException("Country가 없습니다");
		
		return country;
	}
}
