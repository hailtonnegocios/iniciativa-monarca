package br.com.iniciativamonarca.ordemservico.criptografia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class Criptografia {

	public static String encriptarSenha(String senha,String tipo_criptografia) throws NoSuchAlgorithmException {
		if (senha != null && !senha.trim().isEmpty()) {
			MessageDigest md = MessageDigest.getInstance(tipo_criptografia);
			md.update(senha.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			return hash.toString(16);
		}
		return "";
	}
}
