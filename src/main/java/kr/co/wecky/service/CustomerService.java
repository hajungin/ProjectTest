package kr.co.wecky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.wecky.dto.CustomerDto;
import kr.co.wecky.dto.ManagerDto;
import kr.co.wecky.mapper.CustomerMapper;

@Service
public class CustomerService {
	
	@Autowired
	CustomerMapper mapper;

	public List<CustomerDto> customerList() {
		return mapper.customerList();
	}

	public List<CustomerDto> searchCustomer(String keyword) {
		return mapper.searchCustomer(keyword);
	}

	public CustomerDto customerInfo(String keyword) {
		return mapper.customerInfo(keyword);
	}

	public List<ManagerDto> managerList() {
		return mapper.managerList();
	}

	public int saveCustomerData(CustomerDto customerDto) {
		return mapper.save(customerDto);
		
	}

	public ManagerDto selectManager(String id) {
		return mapper.selectManager(id);
	}
	
}
