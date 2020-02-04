package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-04T09:41:26-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AlunoMapperImpl implements AlunoMapper {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Override
    public Aluno toEntity(AlunoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setId( dto.getId() );
        aluno.setMatricula( dto.getMatricula() );
        aluno.setCpf( dto.getCpf() );
        aluno.setNome( dto.getNome() );
        aluno.setDataNascimento( dto.getDataNascimento() );
        aluno.setDisciplinas( disciplinaListagemDTOListToDisciplinaList( dto.getDisciplinas() ) );
        aluno.setAvaliacoes( avaliacaoDetalhadoDTOListToAvaliacaoList( dto.getAvaliacoes() ) );

        return aluno;
    }

    @Override
    public AlunoDTO toDto(Aluno entity) {
        if ( entity == null ) {
            return null;
        }

        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setId( entity.getId() );
        alunoDTO.setNome( entity.getNome() );
        alunoDTO.setCpf( entity.getCpf() );
        alunoDTO.setMatricula( entity.getMatricula() );
        alunoDTO.setDataNascimento( entity.getDataNascimento() );
        alunoDTO.setDisciplinas( disciplinaListToDisciplinaListagemDTOList( entity.getDisciplinas() ) );
        alunoDTO.setAvaliacoes( avaliacaoListToAvaliacaoDetalhadoDTOList( entity.getAvaliacoes() ) );

        return alunoDTO;
    }

    @Override
    public List<Aluno> toEntity(List<AlunoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Aluno> list = new ArrayList<Aluno>( dtoList.size() );
        for ( AlunoDTO alunoDTO : dtoList ) {
            list.add( toEntity( alunoDTO ) );
        }

        return list;
    }

    @Override
    public List<AlunoDTO> toDto(List<Aluno> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AlunoDTO> list = new ArrayList<AlunoDTO>( entityList.size() );
        for ( Aluno aluno : entityList ) {
            list.add( toDto( aluno ) );
        }

        return list;
    }

    protected Disciplina disciplinaListagemDTOToDisciplina(DisciplinaListagemDTO disciplinaListagemDTO) {
        if ( disciplinaListagemDTO == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        disciplina.setId( disciplinaListagemDTO.getId() );
        disciplina.setNome( disciplinaListagemDTO.getNome() );
        disciplina.setDescricao( disciplinaListagemDTO.getDescricao() );
        disciplina.setCargaHoraria( disciplinaListagemDTO.getCargaHoraria() );
        disciplina.setAtiva( disciplinaListagemDTO.getAtiva() );

        return disciplina;
    }

    protected List<Disciplina> disciplinaListagemDTOListToDisciplinaList(List<DisciplinaListagemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Disciplina> list1 = new ArrayList<Disciplina>( list.size() );
        for ( DisciplinaListagemDTO disciplinaListagemDTO : list ) {
            list1.add( disciplinaListagemDTOToDisciplina( disciplinaListagemDTO ) );
        }

        return list1;
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
        avaliacao.setDisciplina( disciplinaListagemDTOToDisciplina( avaliacaoDetalhadoDTO.getDisciplina() ) );
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

    protected DisciplinaListagemDTO disciplinaToDisciplinaListagemDTO(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaListagemDTO disciplinaListagemDTO = new DisciplinaListagemDTO();

        disciplinaListagemDTO.setId( disciplina.getId() );
        disciplinaListagemDTO.setNome( disciplina.getNome() );
        disciplinaListagemDTO.setCargaHoraria( disciplina.getCargaHoraria() );
        disciplinaListagemDTO.setAtiva( disciplina.getAtiva() );
        disciplinaListagemDTO.setDescricao( disciplina.getDescricao() );

        return disciplinaListagemDTO;
    }

    protected List<DisciplinaListagemDTO> disciplinaListToDisciplinaListagemDTOList(List<Disciplina> list) {
        if ( list == null ) {
            return null;
        }

        List<DisciplinaListagemDTO> list1 = new ArrayList<DisciplinaListagemDTO>( list.size() );
        for ( Disciplina disciplina : list ) {
            list1.add( disciplinaToDisciplinaListagemDTO( disciplina ) );
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
        avaliacaoDetalhadoDTO.setDisciplina( disciplinaToDisciplinaListagemDTO( avaliacao.getDisciplina() ) );
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
