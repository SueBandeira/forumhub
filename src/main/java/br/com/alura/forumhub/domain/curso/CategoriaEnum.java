package br.com.alura.forumhub.domain.curso;

public enum CategoriaEnum {

  MOBILE("Mobile"),
  PROGRAMACAO("Programação"),
  FRONT_END("Front-end"),
  DEVOPS("DevOps"),
  UX_DESIGN("UX & Design"),
  DATA_SCIENCE("Data Science"),
  INOVACAO_GESTAO("Inovação & Gestão"),
  INTELIGENCIA_ARTIFICIAL("Inteligência Artificial");

  private final String descricao;

  private CategoriaEnum(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

}
