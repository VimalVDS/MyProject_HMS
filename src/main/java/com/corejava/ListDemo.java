package com.corejava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		List l=new ArrayList();
		l.add(121);
		l.add(123.456);
		l.add("kosmik");
		l.add(false);
		l.add("kosmik");
		System.out.println(l.size());
		System.out.println(l);
		
		/*for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}*/
		
		/*for(Object obj:l){
		System.out.println(obj.toString());	
		}*/
		
		Employee e1=new Employee(101,50000.00,"baskar","kukatpally");
		Employee e2=new Employee(102,50000.00,"kosmik","jntu");
		Employee e3=new Employee(103,60000.00,"srinivas","jntu");
		Employee e4=new Employee(104,50000.00,"keerthi","jntu");
		
		Employee e5=new Employee();
		e5.setEmpId(105);
		e5.setEmpName("kamal");
		e5.setSal(60000.00);
		e5.setAddress("kukatpally");
		
		
		List<Employee> list=new LinkedList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		String str="kosmik";
		System.out.println(str);
		
		System.out.println(list.size());
		System.out.println(list);
		
		for (Employee emp : list) {
			//Employee emp=(Employee)obj;
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
			System.out.println(emp.getSal());
			System.out.println(emp.getAddress());
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
