package br.com.iniciativamonarca.ordemservico.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class ClassUtilitaria {

	public static String encriptarSenha(String senha) throws NoSuchAlgorithmException {
		if (senha != null && !senha.trim().isEmpty()) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			return hash.toString(16);
		}
		return "";
	}
}
