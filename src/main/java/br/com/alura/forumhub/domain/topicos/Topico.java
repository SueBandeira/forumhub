package br.com.alura.forumhub.domain.topicos;


import br.com.alura.forumhub.domain.autor.DadosAutor;
import br.com.alura.forumhub.domain.curso.DadosCurso;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String titulo;

  @Column(unique = true)
  private String mensagem;

  @Column(name = "data_criacao", nullable = false)
  private LocalDateTime dataDeCriacao;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_do_topico", nullable = false)
  private EstadoTopicoEnum estadoDoTopico;

  @Embedded //Serve para que os dados sejam condensados e não crie um outra tabela
  private DadosAutor dadosAutor;

  @Embedded
  private DadosCurso dadosCurso;

  private boolean ativo;

  //-------- Construtores --------//
  public Topico() {}

  public Topico(String titulo, String mensagem, LocalDateTime dataDeCriacao, EstadoTopicoEnum estadoDoTopico, DadosAutor autor, DadosCurso curso) {
    this.titulo = titulo;
    this.mensagem = mensagem;
    this.dataDeCriacao = dataDeCriacao;
    this.estadoDoTopico = estadoDoTopico;
    this.dadosAutor = autor;
    this.dadosCurso = curso;
  }

  public Topico(DadosCadastroTopico dados) {
    this.ativo = true;
    this.titulo = dados.titulo();
    this.mensagem = dados.mensagem();
    this.dataDeCriacao = dados.dataDeCriacao();
    this.estadoDoTopico = dados.estadoDoTopico();
    this.dadosAutor = dados.autor();
    this.dadosCurso = dados.curso();
  }

  //-------- Getters e Setters --------//
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public LocalDateTime getDataDeCriacao() {
    return dataDeCriacao;
  }

  public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
    this.dataDeCriacao = dataDeCriacao;
  }

  public EstadoTopicoEnum getEstadoDoTopico() {
    return estadoDoTopico;
  }

  public void setEstadoDoTopico(EstadoTopicoEnum estadoDoTopico) {
    this.estadoDoTopico = estadoDoTopico;
  }

  public DadosAutor getAutor() {
    return dadosAutor;
  }

  public void setAutor(DadosAutor dadosAutor) {
    this.dadosAutor = dadosAutor;
  }

  public DadosCurso getCurso() {
    return dadosCurso;
  }

  public void setCurso(DadosCurso dadosCurso) {
    this.dadosCurso = dadosCurso;
  }

  public void atualizarinformacoes(DadosAtualizarTopico dados) {
    if (dados.titulo() != null)
      this.titulo = dados.titulo();
    if (dados.mensagem() != null)
      this.mensagem = dados.mensagem();
  }

  public void deletar() {
    this.ativo = false;
  }
}
