package com.driver;

import java.util.List;
import java.util.Scanner;

import com.DAO.MethodImplementation;
import com.DTO.Employee;

public class Main {
	static Scanner sc = null;
public static void main(String[] args) {
	List<Employee> emp;
	Scanner sc = null;
	MethodImplementation m = new MethodImplementation();
	while(true) {
	System.out.println("Enter 1 for get all the details");
	System.out.println("Enter 2 for get one emp details");
	System.out.println("Enter 3 for insert the data");
	System.out.println("Enter 4 for update the data");
	System.out.println("Enter 5 for delete the data");
	System.out.println("Enter 6 to exit");
	
	sc = new Scanner(System.in);
	System.out.println("Enter the choice");
	int choice = sc.nextInt();
	
	if(choice == 6) {
		System.out.println("Exited");
		break;
	}
	switch(choice) {
	case 1:{
		emp = m.getemp();
		for(Object o :emp) {
			System.out.println(o.toString());
		}
		break;
	}
	case 2:{
		System.out.println("Enter the id");
		int num = sc.nextInt();
		m.getid(num);
		break;
	}
	case 3:{
		System.out.println("Enter the id:");
		int num = sc.nextInt();
		System.out.println("Enter the name:");
		String name = sc.next();
		System.out.println("Enter the phnum:");
		int ph = sc.nextInt();
		System.out.println(m.insert(num,name,ph));
		break;
	}
	case 4:{
		System.out.println("Enter the id");
		int id = sc.nextInt();
		Employee empp = m.getid(id);
		System.out.println(m.update(empp));
		break;
	}
	case 5:{
		System.out.println("Enter the id for del");
		int id = sc.nextInt();
		System.out.println(m.delete(id));
		break;
	}
	
	}
}
}
}
