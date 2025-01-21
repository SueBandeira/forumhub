package br.com.alura.forumhub.domain.topicos;

import br.com.alura.forumhub.domain.autor.DadosAutor;
import br.com.alura.forumhub.domain.curso.DadosCurso;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataDeCriacao, EstadoTopicoEnum estadoDoTopico, DadosAutor autor, DadosCurso curso) {

  public DadosDetalhamentoTopico (Topico topico) {
    this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataDeCriacao(), topico.getEstadoDoTopico(), topico.getAutor(), topico.getCurso());
  }

}
