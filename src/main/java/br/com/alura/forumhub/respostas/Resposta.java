package br.com.alura.forumhub.respostas;

import br.com.alura.forumhub.domain.autor.Autor;
import br.com.alura.forumhub.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String solucao;

  @ManyToOne
  @JoinColumn(name = "topico_id", nullable = false)
  private Topico topico;

  @Column(name = "data_criacao", nullable = false)
  private LocalDateTime dataCriacao;

  @ManyToOne
  @JoinColumn(name = "autor_id", nullable = false)
  private Autor autor;

  //-------- Getters e Setters --------//
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSolucao() {
    return solucao;
  }

  public void setSolucao(String solucao) {
    this.solucao = solucao;
  }

  public Topico getTopico() {
    return topico;
  }

  public void setTopico(Topico topico) {
    this.topico = topico;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }
}
