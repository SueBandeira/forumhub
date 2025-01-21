package br.com.alura.forumhub.domain.topicos;


import br.com.alura.forumhub.domain.autor.DadosAutor;
import br.com.alura.forumhub.domain.curso.DadosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record DadosCadastroTopico(@NotBlank
                                  String titulo,
                                  @NotBlank
                                  String mensagem,
                                  @PastOrPresent
                                  LocalDateTime dataDeCriacao,
                                  @NotNull
                                  EstadoTopicoEnum estadoDoTopico,
                                  @NotNull @Valid
                                  DadosAutor autor,
                                  @NotNull @Valid
                                  DadosCurso curso) {
}
