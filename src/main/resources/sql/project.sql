
--
--	Employee
--
select count(*) from dept;
select count(*) from emp;
select count(*) from bonus;
select count(*) from salgrade;

select * from dept;
select * from emp;
select * from bonus;
select * from salgrade;

--
--	World
--
select count(*) from country ;
select count(*) from city ;
select count(*) from countrylanguage ;

select * from country where code='USA';
select * from city where countrycode='USA';
select * from countrylanguage where countrycode='USA';

drop table city;
drop table country;

/*
 * Country
 */
create table country (
	code 			char(3 char),							--국가코드		
	name 			char(52 char),							--국가이름(South Korea)
	continent		char(20 char)	default 'Asia',			--대륙
	region			char(26 char),							--지역
	surface_area	number(10,2)	default '0.00',			--표면적
	indep_year		number(6),								--독립일
	population		number(11)		default 0,				--국가인구
	life_expectancy	number(3,1),							--기대수명
	gnp				number(10,2),							
	gnp_old			number(10,2),
	local_name		char(45 char),							--국가지역이름(대한민국)
	government_form	char(45 char),							
	head_of_state	char(60 char)	default null,
	capital			number(11)		default null,
	code2			char(2  char),
	constraint ck_continent check (continent in ('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')),
	constraint pk_country primary key (code)
);

drop table city;
drop table countrylanguage;
select * from city;
select * from country_language;

/*
 * City
 */
create table city (
	id				number(11)		not null,
	name			char(35 char),
	country_code 	char(3 char),
	district		char(20 char),
	population		number(11)		default 0,
	constraint pk_city primary key (id),
	constraint fk_country foreign key (country_code) references country(code) 
);


/*
 * CountryLanguage
 */
create table country_language (
	country_code	char(3 char),
	language	char(30 char),
	is_official	char(1 char)		default 'F',
	percentage	number(4,1)			default '0.0',
	constraint ck_is_official check (is_official in ('T','F')),
	constraint pk_country_language primary key (country_code, language)
);

select * 
	from dept d join emp e 
		on d.deptno = e.deptno;
		
select d.DEPTNO 	as dept_deptno, 
	   d.DNAME 		as dept_dname,
	   d.LOC 		as dept_loc,
	   e.EMPNO		as emp_empno,
	   e.ENAME 		as emp_ename,
	   e.JOB		as emp_job,
	   e.MGR		as emp_mgr,
	   e.HIREDATE  	as emp_hiredate,
	   e.SAL		as emp_sal,
	   e.COMM		as emp_comm,
	   e.DEPTNO		as emp_deptno
	from dept d left outer join emp e
		on d.DEPTNO = e.DEPTNO; 
		
-- 
-- 	나라정보와 도시정보를 조회하는 쿼리
-- 	country && city
-- 
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
	c1.GOVERNMENT_FORM	as country_gorvernment_form,
	c1.HEAD_OF_STATE	as country_head_of_state,
	c1.CAPITAL			as country_capital,
	c1.CODE2			as country_code2,
	c2.ID				as city_id,	
	c2.NAME				as city_name,
	c2.COUNTRY_CODE		as city_country_code,
	c2.DISTRICT			as city_distinct,
	c2.POPULATION		as city_population
	from country c1 left outer join city c2
		on c1.CODE = c2.COUNTRY_CODE
	where c1.code='KOR';
