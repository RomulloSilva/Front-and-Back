package br.com.biliotecasilva.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biliotecasilva.biblioteca.model.Usuario;
import br.com.biliotecasilva.biblioteca.security.Token;
import br.com.biliotecasilva.biblioteca.security.Validacao;

@RestController//Avisa que teremos EndPoints nessa classe, ou seja URL.
@CrossOrigin("*")
public class UsuarioController {

	
	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario){
		//Simulando a recuperação de um usuário do banco de dados.
		if(usuario.getEmail().equals("romulo@romulo.com") && usuario.getSenha().equals("12345")) {
			usuario.setId(1);
			usuario.setNome("Romulo Underwood");
			
			//Construção do Token.
			String tk = Validacao.generateToken(usuario);
			System.out.println("O token gerado = " +tk);
			Token token = new Token();
			token.setConstruindoToken(tk);
			return ResponseEntity.ok(token);
			
			
			
		}else {
			return ResponseEntity.status(403).build();
		}
	}
	
	
}
