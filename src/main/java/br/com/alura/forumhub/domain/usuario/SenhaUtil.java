package br.com.alura.forumhub.domain.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtil {

  private SenhaUtil() {}

  public static String senhaCripto (String senha) {

    var codificador =  new BCryptPasswordEncoder();
    return codificador.encode(senha);

  }

}
