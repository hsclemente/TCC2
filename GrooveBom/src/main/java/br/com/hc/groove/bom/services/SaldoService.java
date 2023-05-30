package br.com.hc.groove.bom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hc.groove.bom.domain.models.dtos.SaldoDTO;
import br.com.hc.groove.bom.domain.models.entities.Saldo;
import br.com.hc.groove.bom.domain.models.forms.SaldoForm;
import br.com.hc.groove.bom.domain.repositories.SaldoRepository;
import jakarta.validation.Valid;

@Service
public class SaldoService {
    @Autowired
    private SaldoRepository saldoRepository;

    public Page<SaldoDTO> buscarSaldos(Long idExterno, Pageable paginacao) {
        return saldoRepository.findAllByIdExterno(idExterno, paginacao).map(SaldoDTO::new);
    }

    public Long criarSaldo(@Valid SaldoForm form) {
        return saldoRepository.save(new Saldo(form)).getId();
    }
}
