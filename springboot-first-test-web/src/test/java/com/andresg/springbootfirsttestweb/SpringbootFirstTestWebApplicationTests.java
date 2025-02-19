package com.andresg.springbootfirsttestweb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.andresg.springbootfirsttestweb.model.Usuario;
import com.andresg.springbootfirsttestweb.repo.IUsuarioRepo;

@SpringBootTest
class SpringbootFirstTestWebApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void crearUsuarioTest() {
		Usuario user = new Usuario();
		user.setId(3);
		user.setNombre("codex");
		user.setClave(encoder.encode("123"));
		Usuario retorno= repo.save(user);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(user.getClave()));
	}

}
