package kr.co.wecky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.wecky.dto.CustomerDto;
import kr.co.wecky.dto.ManagerDto;

@Mapper
public interface CustomerMapper {

	List<CustomerDto> customerList();

	List<CustomerDto> searchCustomer(@Param("keyword") String keyword);

	CustomerDto customerInfo(@Param("keyword") String keyword);

	List<ManagerDto> managerList();

	int save(@Param("customerDto")CustomerDto customerDto);

	ManagerDto selectManager(@Param("id")String id);

}
