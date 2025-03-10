package mypkg;

public class Employee {
	
	private int empid;
	private String fname;
	private String lname;
	private int salary;
	private int deptid;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		
		
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		
		if(fname == null ||fname.isEmpty()) {
			throw new IllegalArgumentException ("fname cannot be null or empty!");
		}else {
			this.fname = fname;
		}
		
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		
		if(lname == null ||lname.isEmpty()) {
			throw new IllegalArgumentException ("lname cannot be null or empty!");
		}else {
			this.lname = lname;		
			}
		
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	
	
	
	
		
	

}
