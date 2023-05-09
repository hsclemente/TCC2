package br.com.hc.groove.bom.domain.models.dtos;

import br.com.hc.groove.bom.domain.models.entities.Banda;
public record BandaDTO(Long id, String nome, Double saldo) {
    public BandaDTO(Banda banda) {
        this(banda.getId(), banda.getNome(), banda.getSaldo());
    }
}
