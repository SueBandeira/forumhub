package br.com.alura.forumhub.domain.autor;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public record DadosAutor (@NotBlank
                          String nome,
                          @NotBlank @Email
                          String email
                          /*@NotBlank  @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
                          String senha*/){
}
