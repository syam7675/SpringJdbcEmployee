package com.hcl.main;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.hcl.DAO.EmployeeDao;
import com.hcl.DAO.EmployeeDaoImpl;
import com.hcl.beans.Employee;
import com.hcl.config.JdbcConfig;


public class Main {
	static Scanner sc=new Scanner(System.in);
	static int choice=0;
	static int c=0;
	static Employee emp=null;
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		EmployeeDao dao=context.getBean(EmployeeDaoImpl.class);
		
		while(true)
		{
			System.out.println("Menu\n1.Add new employee\n2.Delete employee\n3.Update employee details\n4.get all employees\n5.Get Employee details based on name\n6.exit\nENter your choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter name:");
				String name=sc.next();
				System.out.println("Enter age:");
				int age=sc.nextInt();
				System.out.println("Enter gender:");
				String gender=sc.next();
				emp=new Employee(name,age,gender);
				dao.insert(emp);
				break;
			case 2:
				System.out.println("Enter name:");
				String name2=sc.next();
				c=dao.delete(name2);
				if(c<0)
				{
					System.out.println("Failed to delete");
				}
				break;
			case 3:
				 emp=new Employee("bhoomi",23,"female");
				 c=dao.updates(emp);;
				if(c<0)
				{
					System.out.println("Failed to update");
				}
				
				break;
			case 4:
				List<Employee> list=dao.getAllRecords();
				for(Employee e:list)
				{
					System.out.println(e);
				}
				break;
			case 5:
				System.out.println("Enter name:");
				String name3=sc.next();
				emp=dao.getEmployee(name3);
				System.out.println(emp);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid");
			}
		}
	

	}
	

}
