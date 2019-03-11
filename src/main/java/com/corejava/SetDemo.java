package com.corejava;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		
		Set s=new LinkedHashSet();
		s.add(121);
		s.add(123.456);
		s.add("kosmik");
		s.add(false);
		s.add("kosmik");
		System.out.println(s.size());
		System.out.println(s);
		
		
		Employee e1=new Employee(101,50000.00,"baskar","kukatpally");
		Employee e2=new Employee(102,50000.00,"kosmik","jntu");
		Employee e3=new Employee(103,60000.00,"srinivas","jntu");
		Employee e4=new Employee(104,50000.00,"keerthi","jntu");
		
		Employee e5=new Employee();
		e5.setEmpId(105);
		e5.setEmpName("kamal");
		e5.setSal(60000.00);
		e5.setAddress("kukatpally");
		
		Set<Employee> set=new HashSet<Employee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		for(Employee emp:set){
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
			System.out.println(emp.getSal());
			System.out.println(emp.getAddress());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
