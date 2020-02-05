package br.com.basis.prova.recurso;

import java.net.URISyntaxException;
import java.util.List;

import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.servico.AlunoServico;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/alunos")
public class AlunoRecurso {

    private static final String API_ALUNOS = "/api/alunos";

    private final AlunoServico alunoServico;

    public AlunoRecurso(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> salvar(@Valid @RequestBody AlunoDTO alunoDTO) throws URISyntaxException {
        AlunoDTO result = alunoServico.salvar(alunoDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<AlunoDTO> editar(@Valid @RequestBody AlunoDTO alunoDTO) throws URISyntaxException {
        AlunoDTO result = alunoServico.salvar(alunoDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> excluir(@PathVariable("matricula") String matricula) {
        alunoServico.excluir(matricula);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoListagemDTO>> consultar() {
        return ResponseEntity.ok(alunoServico.consultar());
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<AlunoDTO> detalhar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(alunoServico.detalhar(id));
    }

}
