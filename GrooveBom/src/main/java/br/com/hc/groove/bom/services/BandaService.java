package br.com.hc.groove.bom.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.hc.groove.bom.domain.models.dtos.BandaDTO;
import br.com.hc.groove.bom.domain.models.entities.Banda;
import br.com.hc.groove.bom.domain.models.forms.BandaForm;
import br.com.hc.groove.bom.domain.models.forms.SaldoForm;
import br.com.hc.groove.bom.domain.repositories.BandaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;

    public Page<BandaDTO> buscarBandas(Pageable paginacao) {
        return bandaRepository.findAll(paginacao).map(BandaDTO::new);
    }

    public BandaDTO criarBanda(@Valid BandaForm banda) {
        return new BandaDTO(bandaRepository.save(new Banda(banda)));
    }

    public BandaDTO alterarNome(@Valid BandaForm bandaForm, Long bandaId) {
        Banda banda = bandaRepository.findById(bandaId).orElseThrow(EntityNotFoundException::new);
        banda.setNome(bandaForm.nome());
        
        return new BandaDTO(bandaRepository.save(banda));
    }

    public BandaDTO alterarSaldo(@Valid SaldoForm saldo, Long bandaId) {
        Banda banda = bandaRepository.findById(bandaId).orElseThrow(EntityNotFoundException::new);
        banda.setSaldo(saldo.valor());
        
        return new BandaDTO(bandaRepository.save(banda));
    }
    
}
