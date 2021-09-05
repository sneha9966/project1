package com.testyentra.project;


	import java.util.List;

	import javax.naming.Context;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import org.springframework.stereotype.Component;

	import com.technoelevate.Project1.DAOLayer.*;
	import com.technoelevate.Project1.DTO.DTO_Class;

	@Component
	public class ServiceLayerImplimentation implements ServiceInterface{
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/technoelevate/Project1/config.xml");
		
		DAOClass dao=context.getBean("daoObjcet",DAOClassImplementation.class);
		
		
		public boolean addEmployee(DTOClass dto) {
			
			
			return dao.addEmployee(dto, dto.getUsername(), dto.getPasskey(), dto.getUserid());
		}
		

		public List<DTOClass> getEmployee() {
			
			List<DTOClass> employeeDetails=dao.getEmployee();
			
			return employeeDetails;
		}

		public boolean deleteEmployee(String name) {
			
			dao.deleteEmployee(name);
			
			return true;
		}

		public boolean authentication(String name,String password) {
			
			if(dao.authentication(name, password)!=null) {
				return true;
			}
			return false;
		}


		public boolean search(String name) {
			if(dao.search(name)!=null) {
				return true;
			}
			return false;
		}


		public boolean update(String name, String password) {
			
			if(dao.update(name, password)==true) {
				return true;
			}else {
				return false;
			}
		}
		
	}



