package com.example.util;

import org.junit.Test;

public class PaginationTests {
	
	@Test
	public void test01(){
		Pagination paging = new Pagination();
		paging.setTotalItem(4079);	// select count(*) from city
		paging.setPageNo(19);		// 1 page
		
		System.out.println("itemsPerPage = " + paging.getItemsPerPage());	// 10
		System.out.println("totalPage = " + paging.getTotalPage());			// 408
		System.out.println("firstItem = " + paging.getFirstItem());			// 1
		System.out.println("lastItem = " + paging.getLastItem());			// 10
	}
	@Test
	public void test02(){
		Pagination paging = new Pagination();
		paging.setTotalItem(457);
		
		for(int i=1; i<=paging.getTotalPage(); i++){
			paging.setPageNo(i);
			System.out.println("pageNo = " + paging.getPageNo() + 
							   ", firstItem = " + paging.getFirstItem() + 
							   ", lastItem = " + paging.getLastItem() +
							   ", offset = " + (paging.getFirstItem()-1) + 
							   ", itemsPerPage = "+ paging.getItemsPerPage() );
		}
		
	}
	

}
