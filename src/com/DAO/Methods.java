package com.DAO;

import java.util.List;

import com.DTO.Employee;

public interface Methods {
		List<Employee> getemp();
		Employee getid(int eid);
		boolean	insert(int eid,String ename,int eph);
		boolean	update(Employee e);
		boolean	delete(int eid);
}
