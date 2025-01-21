package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @Autowired
  private TopicoRepository topicoRepository;

  @PostMapping
  @Transactional//métodos de escrita devem ter essa anotação
  public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
    Topico topico = new Topico(dados);
    topicoRepository.save(topico);

    var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();

    return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
  }

  @GetMapping("/{id}")
  public ResponseEntity listarPorId (@PathVariable Long id) {
//    var response =  topicoRepository.findAll();
//    return ResponseEntity.ok(response);
    var topico = topicoRepository.getReferenceById(id);
    return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
  }

  @GetMapping("/topico")
  public ResponseEntity listarTodosPorId () {
    var topico =  topicoRepository.findAll();
    return ResponseEntity.ok(topico);
  }

  @GetMapping
  public ResponseEntity<Page<DadosTopicoCompacto>> listarCompactoTodos (@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
    //return topicoRepository.findAll(paginacao).stream().map(DadosTopicoCompacto::new).toList();
    var page = topicoRepository.findAllByAtivoTrue(paginacao).map(DadosTopicoCompacto::new);
    return ResponseEntity.ok(page);
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizarTopico (@RequestBody @Valid DadosAtualizarTopico dados) {
    var topico = topicoRepository.getReferenceById(dados.id());
    topico.atualizarinformacoes(dados);

    return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity deletarTopico (@PathVariable Long id) {
    //EXCLUSÃO FÍSICA: topicoRepository.deleteById(id);//apaga tudo mesmo, não é indicado, pois pode outros campos precisarem e dar erro
    var topicoDeletar = topicoRepository.getReferenceById(id);
    topicoDeletar.deletar();

    return ResponseEntity.noContent().build();
  }

}
