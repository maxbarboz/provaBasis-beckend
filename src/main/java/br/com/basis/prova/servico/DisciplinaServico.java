package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaListagemMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DisciplinaServico {

    private DisciplinaRepositorio disciplinaRepositorio;
    private DisciplinaMapper disciplinaMapper;
    private DisciplinaListagemMapper disciplinaListagemMapper;
    private DisciplinaDetalhadaMapper disciplinaDetalhadaMapper;

    public DisciplinaServico(DisciplinaMapper disciplinaMapper, DisciplinaRepositorio disciplinaRepositorio, DisciplinaListagemMapper disciplinaListagemMapper, DisciplinaDetalhadaMapper disciplinaDetalhadaMapper) {
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepositorio = disciplinaRepositorio;
        this.disciplinaListagemMapper = disciplinaListagemMapper;
        this.disciplinaDetalhadaMapper = disciplinaDetalhadaMapper;
    }

    public DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);

        if(disciplina.getProfessor() == null){
            throw new RegraNegocioException("Disciplina precisa ter um professor");
        }

        verificaNomeDisciplina(disciplina);
        return disciplinaMapper.toDto(disciplinaRepositorio.save(disciplina));
    }

    public void excluir(Integer id) {
        Disciplina disciplina = disciplinaRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("ID inexistente")
        );

        if(!(disciplina.getAlunos().size() == 0)) {
            throw new RegraNegocioException("A matéria possui alunos matriculados");
        }

        disciplinaRepositorio.delete(disciplina);
    }

    public List<DisciplinaListagemDTO> consultar() {
        List <Disciplina> disciplinas = disciplinaRepositorio.findAll();
        return new ArrayList<>(disciplinaListagemMapper.toDto(disciplinas));
    }

    public DisciplinaDTO detalhar(Integer id) {
        Disciplina disciplina = disciplinaRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("ID inexistente")
        );
        return disciplinaMapper.toDto(disciplina);
    }

    public DisciplinaDetalhadaDTO detalharAvaliacao(Integer id) {
        Disciplina disciplina = disciplinaRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("ID inexistente")
        );
        return disciplinaDetalhadaMapper.toDto(disciplina);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void verificaNomeDisciplina(Disciplina disciplina){
        Disciplina disciplinaNome = disciplinaRepositorio.findByNome(disciplina.getNome());

        if( !(disciplinaNome == null || disciplinaNome.getId().equals(disciplina.getId()))) {
            throw new RegraNegocioException("Já existe uma disciplina com esse nome nos dados.");
        }
    }

}
