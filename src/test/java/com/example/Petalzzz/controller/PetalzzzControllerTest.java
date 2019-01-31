package com.example.Petalzzz.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.petalzzz.api.controller.PetalzzzController;
import com.petalzzz.api.dto.UserTo;
import com.petalzzz.api.repository.PetalzzzRepository;

@RunWith(MockitoJUnitRunner.class)
public class PetalzzzControllerTest {
	@InjectMocks
private PetalzzzController controller;
	@Mock
	private PetalzzzRepository repository;
	
	@Test
	public void getUsersTest() {
		List<UserTo> users = new ArrayList<UserTo>();
		UserTo userTo = new UserTo();
		userTo.setName("AAAAA");
		users.add(userTo);
		when(repository.getUserNAmes()).thenReturn(users);
		assertEquals("AAAAA", users.get(0).getName());
		
	}
	
}
