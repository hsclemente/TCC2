package br.com.hc.groove.bom.domain.models.dtos;

import br.com.hc.groove.bom.domain.models.entities.Saldo;

public record SaldoDTO(Long id, String descricao, Long idExterno) {

    public SaldoDTO(Saldo saldo) {
        this(saldo.getId(), saldo.getDescricao(), saldo.getIdExterno());
    }
}
