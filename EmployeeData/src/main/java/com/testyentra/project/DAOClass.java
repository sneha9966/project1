package com.testyentra.project;


	
	importcom.testyentra.project.DTO.DTOClass;

	import java.util.*;

	import org.springframework.jdbc.core.RowMapper;

	public interface DAOClass {
		
		public boolean addEmployee(DTOClass dto,String userName,String userPassword,String user_id);
		
		public List<DTOClass> getEmployee();
		
		public boolean deleteEmployee(String name);
		
		public List<DTOClass> authentication(String name,String password);
		
		public List<DTOClass> search(String name);
		
		public boolean update(String name,String password);
	}


