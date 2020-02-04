package br.com.basis.prova.servico.mapper;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.dominio.dto.AvaliacaoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-04T13:46:06-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class AvaliacaoDetalhadoMapperImpl implements AvaliacaoDetalhadoMapper {

    @Override
    public Avaliacao toEntity(AvaliacaoDetalhadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setId( dto.getId() );
        avaliacao.setNota( dto.getNota() );
        avaliacao.setData( dto.getData() );
        avaliacao.setDisciplina( disciplinaListagemDTOToDisciplina( dto.getDisciplina() ) );
        avaliacao.setAluno( alunoListagemDTOToAluno( dto.getAluno() ) );

        return avaliacao;
    }

    @Override
    public AvaliacaoDetalhadoDTO toDto(Avaliacao entity) {
        if ( entity == null ) {
            return null;
        }

        AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO = new AvaliacaoDetalhadoDTO();

        avaliacaoDetalhadoDTO.setId( entity.getId() );
        avaliacaoDetalhadoDTO.setNota( entity.getNota() );
        avaliacaoDetalhadoDTO.setData( entity.getData() );
        avaliacaoDetalhadoDTO.setDisciplina( disciplinaToDisciplinaListagemDTO( entity.getDisciplina() ) );
        avaliacaoDetalhadoDTO.setAluno( alunoToAlunoListagemDTO( entity.getAluno() ) );

        return avaliacaoDetalhadoDTO;
    }

    @Override
    public List<Avaliacao> toEntity(List<AvaliacaoDetalhadoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Avaliacao> list = new ArrayList<Avaliacao>( dtoList.size() );
        for ( AvaliacaoDetalhadoDTO avaliacaoDetalhadoDTO : dtoList ) {
            list.add( toEntity( avaliacaoDetalhadoDTO ) );
        }

        return list;
    }

    @Override
    public List<AvaliacaoDetalhadoDTO> toDto(List<Avaliacao> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AvaliacaoDetalhadoDTO> list = new ArrayList<AvaliacaoDetalhadoDTO>( entityList.size() );
        for ( Avaliacao avaliacao : entityList ) {
            list.add( toDto( avaliacao ) );
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
}
