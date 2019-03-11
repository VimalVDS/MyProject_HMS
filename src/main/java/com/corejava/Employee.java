package com.corejava;

public class Employee {

	int empId;
	double sal;
	String empName;
	String address;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empId,double sal1,String empName1,String address1){
		this.empId=empId;
		sal=sal1;
		empName=empName1;
		address=address1;
	}
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return empId+" "+empName+" "+sal+" "+address;
	}
	
	
	
	
	public static void main(String[] args) {
		Employee e=new Employee();
		System.out.println(e.empId);
		System.out.println(e.sal);
		System.out.println(e.empName);
		System.out.println(e.address);
		
		Employee e1=new Employee(10,50000.00,"baskar","jntu");
		
		System.out.println(e1.empId);
		System.out.println(e1.sal);
		System.out.println(e1.empName);
		System.out.println(e1.address);
	}
	
}
