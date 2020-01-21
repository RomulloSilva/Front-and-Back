package br.com.biliotecasilva.biblioteca.security;

import javax.xml.bind.DatatypeConverter;

import br.com.biliotecasilva.biblioteca.model.Usuario;
public class Validacao {
	private static final String PREFIXO="&BIBLIOTECA&";
	
	
	
	/*Aqui é o método que codifica o token em binarios hexadecimais*/
	public static String generateToken(Usuario usuario) {
		String texto = PREFIXO + usuario.toString();
		String Token = DatatypeConverter.printHexBinary(texto.getBytes());
		return Token;
	}
	
	/*Esse é o método que decodifica o token e verifica se o prefixo encontra-se no inicio do token, ou seja, empedi que alguem cole um token diferente em nossa url, uma vez que o prefixo foi definido aqui*/
	public static boolean temPrefixo(String token) {
		byte[] matriz = DatatypeConverter.parseHexBinary(token);
		String novoTexto = new String(matriz);
		System.out.println("Debug = "+novoTexto);
		if(novoTexto.startsWith(PREFIXO)) {
			return true;
		}
		return false;
	}
	
	
	

}
