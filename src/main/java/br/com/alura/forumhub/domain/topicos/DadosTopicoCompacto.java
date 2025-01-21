package br.com.alura.forumhub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record DadosTopicoCompacto(Long id,
                                  @NotBlank String titulo,
                                  @NotBlank String mensagem,
                                  @PastOrPresent LocalDateTime dataDeCriacao) {

  public DadosTopicoCompacto (Topico topico) {
    this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataDeCriacao());
  }
}
