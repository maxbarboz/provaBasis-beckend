package br.com.basis.prova.recurso;

import br.com.basis.prova.dominio.dto.*;
import br.com.basis.prova.servico.NotaAvaliacaoServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/notaavaliacao")
public class NotaAvaliacaoRecurso {

    private static final String API_NOTAAVALIACAO = "/api/notaavaliacao";

    private final NotaAvaliacaoServico notaAvaliacaoServico;

    public NotaAvaliacaoRecurso(NotaAvaliacaoServico notaAvaliacaoServico){
        this.notaAvaliacaoServico = notaAvaliacaoServico;
    }

    @PostMapping
    public ResponseEntity<NotaAvaliacaoDTO> salvar(@RequestBody NotaAvaliacaoDTO notaAvaliacaoDTO) throws URISyntaxException {
        NotaAvaliacaoDTO result= notaAvaliacaoServico.salvar(notaAvaliacaoDTO);
        return ResponseEntity.created(new URI(API_NOTAAVALIACAO + "/" + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<NotaAvaliacaoDTO> editar(@RequestBody NotaAvaliacaoDTO notaAvaliacaoDTO) throws URISyntaxException {
        NotaAvaliacaoDTO result= notaAvaliacaoServico.salvar(notaAvaliacaoDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        notaAvaliacaoServico.excluir(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<NotaAvaliacaoListagemDTO>> consultar() {
        return ResponseEntity.ok(notaAvaliacaoServico.consultar());
    }

}