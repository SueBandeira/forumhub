package br.com.alura.forumhub.domain.usuario;

public record DadosParaUsuario(String login, String senha) {
  public Usuario getUsuario(String login, String senha) {
    return new Usuario(login, senha);
  }
}
