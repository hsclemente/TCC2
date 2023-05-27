package br.com.hc.groove.bom.domain.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hc.groove.bom.domain.models.entities.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long> {
    
    @Query(value = """
            SELECT *
            FROM gb_faqs gf
                INNER JOIN  gb_usuarios gu
                    ON gu.nome ILIKE COALESCE(CAST(:nomeUsuario AS TEXT), gu.nome)
                INNER JOIN gb_bandas gb
                    ON gb.nome ILIKE COALESCE(CAST(:nomeBanda AS TEXT), gb.nome)
            WHERE gf.data = COALESCE(CAST(CAST :dataInicio AS TEXT) AS TIMESTAMP(6), gf.data) between COALESCE(CAST(CAST :dataFim AS TEXT) AS TIMESTAMP(6), gf.data)
            ORDER BY gf.data DESC
            LIMIT :pageSize
            OFFSET (:pageSize * :pageIndex)
        """
        , nativeQuery = true
    )
    List<Faq> buscarFaqs(@Param("nomeUsuario") String nomeUsuario, 
                         @Param("nomeBanda") String nomeBanda,
                         @Param("dataInicio") LocalDateTime dataInicio,
                         @Param("dataFim") LocalDateTime dataFim,
                         @Param("pageSize") int pageSize,
                         @Param("pageIndex") int pageIndex
    );
}
