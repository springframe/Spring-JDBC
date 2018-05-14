package com.shi.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.shi.entity.Employee;

import jdk.nashorn.internal.ir.Flags;

//@Transactional
public class EmployeeDAO {
	
	private HibernateTemplate htemplate;
     boolean Flage=false;
	public void setHtemplate(HibernateTemplate htemplate) {
		this.htemplate = htemplate;
	}
	
	public String saveEmployee(Employee e){  
		System.out.println(e);
	    htemplate.save(e);
	    Flage=true;
	    if(Flage==true)
		return "update data sucessfully";
			else {
				return "not save data in db";
			}  
	}  
	/*//method to update employee  
	public void updateEmployee(Employee e){  
	    template.update(e);  
	}  
	//method to delete employee  
	public void deleteEmployee(Employee e){  
	    template.delete(e);  
	}  
	//method to return one employee of given id  
	public Employee getById(int id){  
	    Employee e=(Employee)template.get(Employee.class,id);  
	    return e;  
	}  
	//method to return all employees  
	public List<Employee> getEmployees(){  
	    List<Employee> list=new ArrayList<Employee>();  
	    list=template.loadAll(Employee.class);  
	    return list;  
	}  */

}
