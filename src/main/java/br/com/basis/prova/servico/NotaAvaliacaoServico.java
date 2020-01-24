package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.NotaAvaliacao;
import br.com.basis.prova.dominio.dto.*;
import br.com.basis.prova.repositorio.NotaAvaliacaoRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.mapper.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NotaAvaliacaoServico {

    private NotaAvaliacaoMapper notaAvaliacaoMapper;
    private NotaAvaliacaoRepositorio notaAvaliacaoRepositorio;
    private NotaAvaliacaoListagemMapper notaAvaliacaoListagemMapper;

    public NotaAvaliacaoServico(NotaAvaliacaoRepositorio notaAvaliacaoRepositorio, NotaAvaliacaoMapper notaAvaliacaoMapper, NotaAvaliacaoListagemMapper notaAvaliacaoListagemMapper){
        this.notaAvaliacaoMapper = notaAvaliacaoMapper;
        this.notaAvaliacaoRepositorio = notaAvaliacaoRepositorio;
        this.notaAvaliacaoListagemMapper = notaAvaliacaoListagemMapper;
    }

    public NotaAvaliacaoDTO salvar(NotaAvaliacaoDTO notaAvaliacaoDTO){
        NotaAvaliacao notaAvaliacao = notaAvaliacaoMapper.toEntity(notaAvaliacaoDTO);
        return notaAvaliacaoMapper.toDto(notaAvaliacaoRepositorio.save(notaAvaliacao));
    }

    public void excluir(Integer id){
        NotaAvaliacao notaAvaliacao = notaAvaliacaoRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("Id não encontrado nos dados.")
        );
        notaAvaliacaoRepositorio.delete(notaAvaliacao);
    }

    public List<NotaAvaliacaoListagemDTO> consultar(){
        List <NotaAvaliacao> notaAvaliacaos = notaAvaliacaoRepositorio.findAll();
        return new ArrayList<>(notaAvaliacaoListagemMapper.toDto(notaAvaliacaos));
    }

}
