package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AvaliacaoDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoListagemDTO;
import br.com.basis.prova.repositorio.AvaliacaoRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import br.com.basis.prova.servico.mapper.AvaliacaoDetalhadoMapper;
import br.com.basis.prova.servico.mapper.AvaliacaoListagemMapper;
import br.com.basis.prova.servico.mapper.AvaliacaoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AvaliacaoServico {

    private AvaliacaoMapper avaliacaoMapper;
    private AvaliacaoRepositorio avaliacaoRepositorio;
    private AvaliacaoListagemMapper avaliacaoListagemMapper;
    private AvaliacaoDetalhadoMapper avaliacaoDetalhadoMapper;

    public AvaliacaoServico(AvaliacaoMapper avaliacaoMapper, AvaliacaoRepositorio avaliacaoRepositorio, AvaliacaoListagemMapper avaliacaoListagemMapper, AvaliacaoDetalhadoMapper avaliacaoDetalhadoMapper){
        this.avaliacaoMapper = avaliacaoMapper;
        this.avaliacaoRepositorio = avaliacaoRepositorio;
        this.avaliacaoListagemMapper = avaliacaoListagemMapper;
        this.avaliacaoDetalhadoMapper = avaliacaoDetalhadoMapper;
    }

    public AvaliacaoDTO salvar(AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoMapper.toEntity(avaliacaoDTO);
        return avaliacaoMapper.toDto(avaliacaoRepositorio.save(avaliacao));
    }

    public void excluir(Integer id){
        Avaliacao avaliacao = avaliacaoRepositorio.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException("Id não encontrado nos dados.")
        );
        avaliacaoRepositorio.delete(avaliacao);
    }

    public List<AvaliacaoListagemDTO> consultar(){
        List <Avaliacao> avaliacoes = avaliacaoRepositorio.findAll();
        return new ArrayList<>(avaliacaoListagemMapper.toDto(avaliacoes));
    }

    public AvaliacaoDetalhadoDTO detalhar(Integer id) {
        Avaliacao avaliacao = avaliacaoRepositorio.findById(id).orElseThrow(
                () -> new RegraNegocioException("ID inexistente")
        );
        return avaliacaoDetalhadoMapper.toDto(avaliacao);
    }



}
