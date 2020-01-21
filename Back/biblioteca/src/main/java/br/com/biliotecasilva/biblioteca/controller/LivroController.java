package br.com.biliotecasilva.biblioteca.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.biliotecasilva.biblioteca.model.Livro;
import br.com.biliotecasilva.biblioteca.security.Validacao;

@RestController
@CrossOrigin("*")
public class LivroController {
	
	
	@GetMapping("/catalogo")
	public ResponseEntity<ArrayList<Livro>> getAllLivros(@RequestParam String token){
		if(Validacao.temPrefixo(token)) {
			/*Este trecho simula a leitura de um banco de dados*/
			
			ArrayList<Livro> lista = new ArrayList<Livro>();
			for(int i = 0; i < 20; i++) {
				Livro book = new Livro();
				book.setAnoDePublicacao(2020+i);
				book.setTitulo("Livro "+i);
				book.setEstante(i);
				book.setPrateleira((i*5));
				
				lista.add(book);
				
			}
			return ResponseEntity.ok(lista);
		} else {
			return ResponseEntity.status(403).build();
		}
	}

}
