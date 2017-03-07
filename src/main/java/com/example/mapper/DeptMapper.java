package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Dept;

@Mapper
public interface DeptMapper {

	@Select("select * from dept")
	List<Dept> selectAll();
	List<Dept> selectAllWithEmp();
	
	@Select({
		"select *							",
		"  from dept						",
		"order by deptno					",
		"offset #{fisrtItem} -1 rows		",
		"fetch next #{itemsPerPage} rows only"
	})
	List<Dept> selectPage();
	List<Dept> selectPageWithEmp();
	
	@Select("select * from dept where deptno=#{deptno}")
	Dept selectByDeptno(int deptno);
	Dept selectByDeptnoWithEmp(int deptno);
	
}
