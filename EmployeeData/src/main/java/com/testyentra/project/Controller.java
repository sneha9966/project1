package com.testyentra.project;


	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;

	import com.technoelevate.Project1.DTO.DTO_Class;
	import com.technoelevate.Project1.ServiceLayer.ServiceLayerImplimentation;

	@org.springframework.stereotype.Controller
	
		
	public class Controller {
		@Autowired
		ServiceLayerImplimentation service;
		
		
		@GetMapping("/register")
		public String frontPage() {
			return"register";
		}
		
		@PostMapping("/addEmployee")
		public String addEmployee(ModelMap map,DTO_Class dto) {
			
			map.addAttribute("DTO_Object",dto);
		
			service.addEmployee(dto);
			
			return"addemployeestatus";
		}
		
		@GetMapping("/getEmployee")
		public String allEmployee() {
			return"allEmployee";
		}
		
		@GetMapping("/getallemployee")
		public String getAllEmployees(ModelMap map,DTO_Class dto) {
			
			map.addAttribute("myEmploeeDetails",service.getEmployee());
			
			return "getallemployee";
		}
		
		@GetMapping("/delete")
		public String deleteEmployeeDetail() {
			return "delete";
		}
		@PostMapping("/deletemployee")
		public String deleteEmployee(ModelMap map,DTO_Class dto) {
			
			map.addAttribute("MyD/toObject",dto);
			map.addAttribute("name",dto.getUsername());
			
			if(dto.getUsername()!=null) {
				service.deleteEmployee(dto.getUsername());
				map.addAttribute("status","Deleted");
			}else {
				map.addAttribute("status","Not Deleted");
			}
			return "deleteEmployee";
		}
		
		@GetMapping("/login")
		public String authentication(DTO_Class dto,HttpServletRequest req) {
			HttpSession session=req.getSession();
			session.setAttribute("name",dto.getUsername());
			return "authenticationpage";
		}
		
		@PostMapping("/logincredential")
		public String authentication(ModelMap map,DTO_Class dto) {
			
			map.addAttribute("MyDtoObject",dto);
			
			if(dto.getUsername()!=null) {
				
				
				if(service.authentication(dto.getUsername(), dto.getPasskey())){
					
					;
					
					map.addAttribute("status","Login successfull");
					map.addAttribute("username",dto.getUsername());
					
					return "authentication";
				}else{
					map.addAttribute("status","login Failed");
					return "authentication1";
				}
			}
			return "authentication2";
			
		}
		@GetMapping("/logout")
		
		public String logout() {
			
			return "authenticationpage";
		}
		
		@GetMapping("/search")
		public String searchEmployee() {
			
			return "searchpage";
		}
		
		@PostMapping("/searchemployee")
		public String searchEmployeeInDataBase(ModelMap map,DTO_Class dto) {
			
			map.addAttribute("DtoObjcet",dto);
			map.addAttribute("name",dto.getUsername());
			if(dto.getUsername()!=null) {
				if(service.search(dto.getUsername())==true) {
					map.addAttribute("status","Record is their");
				}else {
					map.addAttribute("status","Record not their");
				}
			}
			return "searchstatus";
		}
		
		@GetMapping("/update")
		public String update() {
			
			return "updatepage";
			
		}
		
		@PostMapping("/updateemployee")
		public String updateEmployee(ModelMap map,DTO_Class dto) {
			
			map.addAttribute("dtoOject",dto);
			map.addAttribute("name",dto.getUsername());
			
			if(dto.getUsername()!=null) {
				
				if(service.search(dto.getUsername())==true) {
					
					map.addAttribute("Record","Record is their");
					
					if(service.update(dto.getUsername(), dto.getPasskey())) {
						
						map.addAttribute("status","Record updated");
						
					}else {
						
						map.addAttribute("status","Record Not updated");
					}
				}else {
					map.addAttribute("Record","Record is not their");
				}
			}
			return "updateemployee";
		}
	}


}
