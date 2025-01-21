package br.com.alura.forumhub.domain.curso;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String curso;
  private CategoriaEnum categoria;

  public Curso() {}

  public Curso(String curso, CategoriaEnum categoria) {
    this.curso = curso;
    this.categoria = categoria;
  }

  public Curso(Long id, String curso, CategoriaEnum categoria) {
    this.id = id;
    this.curso = curso;
    this.categoria = categoria;
  }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public CategoriaEnum getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaEnum categoria) {
    this.categoria = categoria;
  }
}
