package com.corejava;

import java.util.LinkedList;
import java.util.List;

public class CallByReference {

	public static void main(String[] args) {
		
		Employee e1=new Employee(101,50000.00,"baskar","kukatpally");
		
		List<Employee> list=new LinkedList<Employee>();
		list.add(e1);
		e1.setEmpName("kosmik");
		for (Employee employee : list) {
			System.out.println(employee.getEmpName());
		}

	}

}
