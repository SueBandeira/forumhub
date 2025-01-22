package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.usuario.DadosAutenticacao;
import br.com.alura.forumhub.domain.usuario.Usuario;
import br.com.alura.forumhub.domain.usuario.UsuarioRepository;
import br.com.alura.forumhub.infra.security.DadosTokenJWT;
import br.com.alura.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UsuarioRepository repository;

//  @PostMapping
//  public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao dados) {
//   var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
//    var authentication = manager.authenticate(authenticationToken);
//
//    var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
//
//    //return ResponseEntity.ok().build();
//    return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
//  }

  @PostMapping
  public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) throws Exception {
    System.out.println("DADOS:" + dados);

    try {
      var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
      var authentication = manager.authenticate(authenticationToken);

      var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

      return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception(e.getMessage());
    }
  }

  @PostMapping("/cadastro")
  public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosAutenticacao dados) {
    var userNovo = repository.save(new Usuario(dados.login(), dados.senha()));

    return ResponseEntity.ok(userNovo);
  }

}
