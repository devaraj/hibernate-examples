package com.examples.dev;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.examples.dev.domain.model.Department;
import com.examples.dev.domain.model.Employee;
import com.examples.dev.sessionfactory.SingletonSessionFactory;

public class JoinFetch {

    public static void main(String[] args){

    	Session sess=  SingletonSessionFactory.getSession();
    	Transaction transaction = sess.beginTransaction();
//    	org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer
    	
    	Criteria criteria = sess.createCriteria(Employee.class);
    	criteria.add(Restrictions.eq("empId",1));
    	Employee e = (Employee) criteria.uniqueResult();
    	System.out.println(e.getEmpName()+e.getDepartment());
    	
    	criteria = sess.createCriteria(Department.class);
    	criteria.add(Restrictions.eq("departmentId",1));
    	Department dept= (Department) criteria.uniqueResult();
    	System.out.println(dept.getDeptName()+dept.getEmployees());
    	
    	transaction.commit();
    	sess.close();
    	
    }

}
