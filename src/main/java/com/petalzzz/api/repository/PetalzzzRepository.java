package com.petalzzz.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.petalzzz.api.dto.UserTo;
@Repository
public class PetalzzzRepository {
	@Autowired
	private JdbcTemplate template;
	public List<UserTo> getUserNAmes() {
		List<UserTo> names = new ArrayList<UserTo>();
		names=template.query("select id,name,phone from public.users", new BeanPropertyRowMapper<UserTo>(UserTo.class));
		return names;
		
	}
	public String addUser(String userName,String phone) {
		String sql="INSERT INTO public.users( " + 
				"	name, phone) " + 
				"	VALUES (?, ?)";
		int result = template.update(sql,new Object[] {userName,phone});
		return result==1?"SUCCESS":"FAILED";
	}
	

}
