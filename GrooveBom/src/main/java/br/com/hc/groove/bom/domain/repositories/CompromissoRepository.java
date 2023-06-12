package br.com.hc.groove.bom.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hc.groove.bom.domain.models.entities.Compromisso;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{
    @Query(value = """
        SELECT * FROM gb_compromissos
        WHERE fk_destinatario = :idDestinatario
        ORDER BY data
        LIMIT :pageSize
        OFFSET (:pageSize * :pageIndex)     
        """
            , nativeQuery = true
    )
    List<Compromisso> buscarCompromissos(@Param("idDestinatario") Long idDestinatario,
                                         @Param("pageSize") Integer pageSize,
                                         @Param("pageIndex") Integer pageIndex
    );

    @Query(value="""
        SELECT * FROM gb_compromissos
        WHERE fk_destinatario = :idDestinatario
            AND is_show = true
            AND is_concluido = true
        ORDER BY data
        """
            , nativeQuery = true
    )
    List<Compromisso> buscarGraficos(@Param("idDestinatario")Long destinatarioId);

}