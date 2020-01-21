package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.DisciplinaDetalhadaMapper;
import br.com.basis.prova.servico.mapper.DisciplinaListagemMapper;
import br.com.basis.prova.servico.mapper.DisciplinaMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    // NÃO PODE CONTER DUAS DISCIPLINAS COM O MESMO NOME
    public DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaDTO);

        return disciplinaMapper.toDto(disciplinaRepositorio.save(disciplina));
    }

    // CORRETO
    public void excluir(Integer id) {
        Disciplina disciplina = disciplinaRepositorio.findById(id).orElseThrow(
                () -> new RegraNegocioException("ID inexistente")
        );

        disciplinaRepositorio.delete(disciplina);
    }

    // CORRETO
    public List<DisciplinaListagemDTO> consultar() {
        return disciplinaListagemMapper.toDto(disciplinaRepositorio.findAll());
    }

    // CORRETO
    public DisciplinaDetalhadaDTO detalhar(Integer id) {
        Disciplina disciplina = disciplinaRepositorio.findById(id).orElseThrow(
                () -> new RegraNegocioException("ID inexistente")
        );
        return disciplinaDetalhadaMapper.toDto(disciplina);
    }

}
