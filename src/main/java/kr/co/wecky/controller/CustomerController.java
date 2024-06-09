package kr.co.wecky.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.wecky.dto.CustomerDto;
import kr.co.wecky.dto.ManagerDto;
import kr.co.wecky.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customerManage")
	public String customerList() {
		return "customer/customer_list";
	}

	@PostMapping("/customerList")
	@ResponseBody
	public List<CustomerDto> getListCustomer() {
		List<CustomerDto> dtos = customerService.customerList();
		return dtos;
	}
	
	@PostMapping("/customerOne")
	@ResponseBody
	public List<CustomerDto> getOneListCustomer(@RequestBody Map<String, String> body) {
		String keyword = body.get("keyword");
	
		List<CustomerDto> dtos = customerService.searchCustomer(keyword);
		return dtos;
	}
	
	@PostMapping("/customerInfo")
	@ResponseBody
	public CustomerDto getCustomer(@RequestBody Map<String, String> body) {
		String keyword = body.get("keyword");
		System.out.println("keyword = " + keyword);
		
		CustomerDto dtos = customerService.customerInfo(keyword);
		return dtos;
	}
	
	@GetMapping("/managerList")
	public String managerList(Model model) {
		List<ManagerDto> dtos = customerService.managerList();
		model.addAttribute("dtos", dtos);
		return "/customer/manager_select";
	}
	
	@PostMapping("/saveCustomerData")
	@ResponseBody
	public String saveCustomerData(@RequestBody CustomerDto customerDto) {
	    // 변경된 고객 데이터 처리 및 저장
		System.out.println(customerDto.toString());
	    customerService.saveCustomerData(customerDto);
	    System.out.println(customerDto.toString());
	    // 저장 후 이동할 페이지나 메시지를 반환
	    return "redirect:/customerManage"; // 저장 후 고객 관리 페이지로 이동
	}
	
	@PostMapping("/SelectedManager")
	public String SelectedManager(@RequestParam("id") String id) {
	    ManagerDto managerDto = customerService.selectManager(id);
	    System.out.println(managerDto.toString());
	    return "redirect:/customerManage"; // 혹은 실제 페이지 경로로 수정
	}


}
