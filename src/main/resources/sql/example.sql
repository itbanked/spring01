
select table_name from user_tables;

select * from city where country_code='KOR';

select 
		   e.EMPNO		as emp_empno,
		   e.ENAME 		as emp_ename,
		   e.JOB		as emp_job,
		   e.MGR		as emp_mgr,
		   e.HIREDATE  	as emp_hiredate,
		   e.SAL		as emp_sal,
		   e.COMM		as emp_comm,
		   e.DEPTNO		as emp_deptno,
 		   d.DEPTNO 	as dept_deptno, 
		   d.DNAME 		as dept_dname,
		   d.LOC 		as dept_loc
  from emp e left outer join dept d 
	on e.deptno = d.deptno;
	
	select 
		c1.CODE 			as country_code,
		c1.NAME 			as country_name,
		c1.CONTINENT 		as country_continent,
		c1.region			as couintry_region,
		c1.SURFACE_AREA 	as country_surface_area,
		c1.INDEP_YEAR		as country_indep_year,
		c1.POPULATION 		as country_population,
		c1.LIFE_EXPECTANCY	as country_life_expectancy,
		c1.gnp				as country_gnp,
		c1.GNP_OLD			as country_gnp_old,
		c1.LOCAL_NAME		as country_local_name,
		c1.GOVERNMENT_FORM	as country_government_form,
		c1.HEAD_OF_STATE	as country_head_of_state,
		c1.CAPITAL			as country_capital,
		c1.CODE2			as country_code2,
		c2.ID				as city_id,	
		c2.NAME				as city_name,
		c2.COUNTRY_CODE		as city_country_code,
		c2.DISTRICT			as city_district,
		c2.POPULATION		as city_population
		from country c1 left outer join city c2
			on c1.CODE = c2.COUNTRY_CODE
		where c1.code='KOR';
		