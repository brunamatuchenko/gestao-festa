package br.gov.etec.gestaofesta2.controller;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.etec.gestaofesta2.model.Login;
import br.gov.etec.gestaofesta2.repository.LoginRepository;

@Controller
public class LoginController {
	
	@Autowired
	LoginRepository repository;
	
	
	@GetMapping("/")
	public String openLogin() {
		return "login";
	}
	
	@GetMapping("login/cadastrar")
	public String logincadastrar() {
		return "cadastro-login";
	}
	
	@PostMapping("/login/salvar")
	public String salvarCadastro (Login login) {
		repository.save(login);
		return "login";

	}
	
	
	
	@PostMapping("/efetuar-login")
	public String openLogin(Login login) {
		
		Login loginBanco= repository.findByEmail(login.getEmail());
		
		if (login.getEmail().equals(loginBanco.getEmail()) 
				&&login.getSenha().equals(loginBanco.getSenha())) {
		return "redirect:convidado/lista-convidados"; 
		} else {
			
			return "login";
			
		}
				
	}
	
	
	
	
	
	
}
