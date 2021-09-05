package com.testyentra.project;



	import java.sql.ResultSet;
	import java.sql.SQLException;

	import org.springframework.jdbc.core.RowMapper;

	import com.testyentra.project.DTO.DTOClass;

	public class RowMapperImplementation implements RowMapper<DTOClass>{

		public DTOClass mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			DTOClass dto=new DTOClass();
			
			dto.setUsername(rs.getString(1));
			dto.setPasskey(rs.getString(2));
			dto.setUserid(rs.getString(3));
			
			return dto;
		}

		
	}



