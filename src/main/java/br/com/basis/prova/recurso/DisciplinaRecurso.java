package br.com.basis.prova.recurso;

import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import br.com.basis.prova.servico.DisciplinaServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaRecurso {

    private static final String API_DISCIPLINAS = "/api/disciplinas";

    private final DisciplinaServico disciplinaServico;

    public DisciplinaRecurso(DisciplinaServico disciplinaServico) {
        this.disciplinaServico = disciplinaServico;
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> salvar(@RequestBody DisciplinaDTO disciplinaDTO) throws URISyntaxException {
        DisciplinaDTO result = disciplinaServico.salvar(disciplinaDTO);
        return ResponseEntity.ok(result);
        //return ResponseEntity.created(new URI(API_DISCIPLINAS + "/" + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<DisciplinaDTO> editar(@RequestBody DisciplinaDTO disciplinaDTO) throws URISyntaxException {
        DisciplinaDTO result = disciplinaServico.salvar(disciplinaDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        disciplinaServico.excluir(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaListagemDTO>> consultar() {
        return ResponseEntity.ok(disciplinaServico.consultar());
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<DisciplinaDTO> detalhar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(disciplinaServico.detalhar(id));
    }

}
