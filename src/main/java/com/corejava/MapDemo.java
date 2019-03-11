package com.corejava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		
		Map m=new HashMap();
		m.put(121, "kosmik");
		m.put(122, "baskar");
		m.put(123, "srilakshmi");
		m.put(121, "ksomik1");
		System.out.println(m);
		
		Map<Integer,Employee> listMap=new LinkedHashMap<Integer,Employee>();
		
		Employee e1=new Employee(101,50000.00,"baskar","kukatpally");
		Employee e2=new Employee(102,50000.00,"kosmik","jntu");
		Employee e3=new Employee(103,60000.00,"srinivas","jntu");
		Employee e4=new Employee(104,50000.00,"keerthi","jntu");
		
		Employee e5=new Employee();
		e5.setEmpId(105);
		e5.setEmpName("kamal");
		e5.setSal(60000.00);
		e5.setAddress("kukatpally");
		
		listMap.put(e1.getEmpId(),e1);
		listMap.put(e2.getEmpId(),e1);
		listMap.put(e3.getEmpId(),e1);
		listMap.put(e4.getEmpId(),e1);
		listMap.put(e5.getEmpId(),e1);
		
		Set<Entry<Integer, Employee>> set=listMap.entrySet();
		
		for (Entry<Integer, Employee> entry : set) {
			
			System.out.println(entry.getKey());
			Employee emp=entry.getValue();
			System.out.println(emp.getEmpName());
			System.out.println(emp.getSal());
			System.out.println(emp.getAddress());
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
