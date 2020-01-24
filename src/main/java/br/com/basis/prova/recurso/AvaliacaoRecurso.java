package br.com.basis.prova.recurso;

import br.com.basis.prova.dominio.dto.*;
import br.com.basis.prova.servico.AvaliacaoServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoRecurso {

    private static final String API_AVALIACOES = "/api/avaliacoes";
    private AvaliacaoServico avaliacaoServico;

    public AvaliacaoRecurso(AvaliacaoServico avaliacaoServico){
        this.avaliacaoServico = avaliacaoServico;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> salvar(@RequestBody AvaliacaoDTO avaliacaoDTO) throws URISyntaxException {
        AvaliacaoDTO result= avaliacaoServico.salvar(avaliacaoDTO);
        return ResponseEntity.created(new URI(API_AVALIACOES + "/" + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<AvaliacaoDTO> editar(@RequestBody AvaliacaoDTO avaliacaoDTO) throws URISyntaxException {
        AvaliacaoDTO result= avaliacaoServico.salvar(avaliacaoDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id){
        avaliacaoServico.excluir(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoListagemDTO>> consultar() {
        return ResponseEntity.ok(avaliacaoServico.consultar());
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<AvaliacaoDetalhadoDTO> detalhar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(avaliacaoServico.detalhar(id));
    }

}
