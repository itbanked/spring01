package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.City;
import com.example.util.Pagination;

@Mapper
public interface CityMapper {
	
	@Select("select count(*) from city")
	int selectTotalCount();
	
	@Select("select * from city")
	List<City> selectAll();
	
	List<City> selectAllWithCountry(); // country left outer join city
	
	@Select({
		"select *",
		"  from city",
		"order by id",
		"offset #{firstItem}-1 rows",
		" fetch next #{itemsPerPage} rows only"
	})
	List<City> selectPage(Pagination paging);		//10Line paging
	List<City> selectPageWithCountry(Pagination paging);	//country left outer join city && 10Line Paging
	
	@Select("select * from city where id=#{id}")
	City selectById(int id);			//city id
	City selectByIdWithCountry(int id);	//country left outer join city && id
	

}
