package br.com.hc.groove.bom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hc.groove.bom.domain.models.dtos.CompromissoDTO;
import br.com.hc.groove.bom.domain.models.entities.Compromisso;
import br.com.hc.groove.bom.domain.models.forms.CompromissoForm;
import br.com.hc.groove.bom.domain.repositories.CompromissoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository compromissoRepository;

    public List<CompromissoDTO> buscarCompromissos(Long destinatarioId, Integer pageSize, Integer pageIndex) {
        return compromissoRepository.buscarCompromissos(destinatarioId, pageSize, pageIndex).stream().sorted().map(CompromissoDTO::new).collect(Collectors.toList());
    }

    public CompromissoDTO criarComprimisso(@Valid CompromissoForm form) {
        return new CompromissoDTO(compromissoRepository.save(new Compromisso(form)));
    }

    public CompromissoDTO concluirCompromisso(Long compromissoId) {
        Compromisso compromisso = compromissoRepository.findById(compromissoId).orElseThrow(EntityNotFoundException::new);
        compromisso.setIsConcluido(true);
        return new CompromissoDTO(compromissoRepository.save(compromisso));
    }

    public String deletarCompromisso(Long compromissoId) {
        compromissoRepository.deleteById(compromissoId);
        return "Compromisso deletado com sucesso";
    }

    public List<CompromissoDTO> buscarGraficos(Long destinatarioId) {
        return compromissoRepository.buscarGraficos(destinatarioId).stream().map(CompromissoDTO::new).collect(Collectors.toList());
    }
}