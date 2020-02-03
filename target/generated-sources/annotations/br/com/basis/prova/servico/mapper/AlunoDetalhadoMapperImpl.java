package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoDetalhadoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-03T07:13:45-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AlunoDetalhadoMapperImpl implements AlunoDetalhadoMapper {

    @Autowired
    private DisciplinaListagemMapper disciplinaListagemMapper;

    @Override
    public Aluno toEntity(AlunoDetalhadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( dto.getId() );
        aluno.setMatricula( dto.getMatricula() );
        aluno.setNome( dto.getNome() );
        aluno.setDisciplinas( disciplinaListagemMapper.toEntity( dto.getDisciplinas() ) );
        aluno.setAvaliacoes( avaliacaoDetalhadoDTOListToAvaliacaoList( dto.getAvaliacoes() ) );

        return aluno;
    }

    @Override
    public AlunoDetalhadoDTO toDto(Aluno entity) {
        if ( entity == null ) {
            return null;
        }

        AlunoDetalhadoDTO alunoDetalhadoDTO = new AlunoDetalhadoDTO();

        alunoDetalhadoDTO.setId( entity.getId() );
        alunoDetalhadoDTO.setNome( entity.getNome() );
        alunoDetalhadoDTO.setMatricula( entity.getMatricula() );
        alunoDetalhadoDTO.setDisciplinas( disciplinaListagemMapper.toDto( entity.getDisciplinas() ) );
        alunoDetalhadoDTO.setAvaliacoes( avaliacaoListToAvaliacaoDetalhadoDTOList( entity.getAvaliacoes() ) );

        return alunoDetalhadoDTO;
    }

    @Override
    public List<Aluno> toEntity(List<AlunoDetalhadoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( dtoList.size() );
        for ( AlunoDetalhadoDTO alunoDetalhadoDTO : dtoList ) {
            list.add( toEntity( alunoDetalhadoDTO ) );
        }

        return list;
    }

    @Override
    public List<AlunoDetalhadoDTO> toDto(List<Aluno> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AlunoDetalhadoDTO> list = new ArrayList<AlunoDetalhadoDTO>( entityList.size() );
        for ( Aluno aluno : entityList ) {
            list.add( toDto( aluno ) );
        }

        return list;
    }

    protected Aluno alunoListagemDTOToAluno(AlunoListagemDTO alunoListagemDTO) {
        if ( alunoListagemDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( alunoListagemDTO.getId() );
        aluno.setMatricula( alunoListagemDTO.getMatricula() );
        aluno.setNome( alunoListagemDTO.getNome() );
        aluno.setDataNascimento( alunoListagemDTO.getDataNascimento() );

        return aluno;
    }

    protected Avaliacao avaliacaoDetalhadoDTOToAvaliacao(AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO) {
        if ( avaliacaoDetalhadoDTO == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setId( avaliacaoDetalhadoDTO.getId() );
        avaliacao.setNota( avaliacaoDetalhadoDTO.getNota() );
        avaliacao.setData( avaliacaoDetalhadoDTO.getData() );
        avaliacao.setDisciplina( disciplinaListagemMapper.toEntity( avaliacaoDetalhadoDTO.getDisciplina() ) );
        avaliacao.setAluno( alunoListagemDTOToAluno( avaliacaoDetalhadoDTO.getAluno() ) );

        return avaliacao;
    }

    protected List<Avaliacao> avaliacaoDetalhadoDTOListToAvaliacaoList(List<AvaliacaoDetalhadoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Avaliacao> list1 = new ArrayList<Avaliacao>( list.size() );
        for ( AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO : list ) {
            list1.add( avaliacaoDetalhadoDTOToAvaliacao( avaliacaoDetalhadoDTO ) );
        }

        return list1;
    }

    protected AlunoListagemDTO alunoToAlunoListagemDTO(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        AlunoListagemDTO alunoListagemDTO = new AlunoListagemDTO();

        alunoListagemDTO.setId( aluno.getId() );
        alunoListagemDTO.setNome( aluno.getNome() );
        alunoListagemDTO.setMatricula( aluno.getMatricula() );
        alunoListagemDTO.setDataNascimento( aluno.getDataNascimento() );

        return alunoListagemDTO;
    }

    protected AvaliacaoDetalhadoDTO avaliacaoToAvaliacaoDetalhadoDTO(Avaliacao avaliacao) {
        if ( avaliacao == null ) {
            return null;
        }

        AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO = new AvaliacaoDetalhadoDTO();

        avaliacaoDetalhadoDTO.setId( avaliacao.getId() );
        avaliacaoDetalhadoDTO.setNota( avaliacao.getNota() );
        avaliacaoDetalhadoDTO.setData( avaliacao.getData() );
        avaliacaoDetalhadoDTO.setDisciplina( disciplinaListagemMapper.toDto( avaliacao.getDisciplina() ) );
        avaliacaoDetalhadoDTO.setAluno( alunoToAlunoListagemDTO( avaliacao.getAluno() ) );

        return avaliacaoDetalhadoDTO;
    }

    protected List<AvaliacaoDetalhadoDTO> avaliacaoListToAvaliacaoDetalhadoDTOList(List<Avaliacao> list) {
        if ( list == null ) {
            return null;
        }

        List<AvaliacaoDetalhadoDTO> list1 = new ArrayList<AvaliacaoDetalhadoDTO>( list.size() );
        for ( Avaliacao avaliacao : list ) {
            list1.add( avaliacaoToAvaliacaoDetalhadoDTO( avaliacao ) );
        }

        return list1;
    }
}
