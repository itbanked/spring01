package com.example.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Emp;
import com.example.emp.service.EmpSearchService;

@Controller
@RequestMapping("/emp")
public class EmpSearchController {

	@Autowired
	EmpSearchService empSearchService;
	
	@GetMapping("/list")
	public String getList(Model model){
		List<Emp> list = empSearchService.getList();
		model.addAttribute("list", list);
		
		return "emp/list";
	}
	
	@GetMapping("/item")
	public String getItemWithDept(Model model){
		Emp item = empSearchService.getByEmpno(7499, true);
		model.addAttribute("item", item);
		return "emp/list";
	}
}
