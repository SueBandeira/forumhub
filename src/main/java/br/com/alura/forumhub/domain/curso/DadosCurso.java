package br.com.alura.forumhub.domain.curso;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public record DadosCurso(@NotBlank
                         String curso,
                         @NotNull
                         CategoriaEnum categoria) {
}
