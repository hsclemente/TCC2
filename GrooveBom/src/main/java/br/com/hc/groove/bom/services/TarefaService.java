package br.com.hc.groove.bom.services;

import br.com.hc.groove.bom.domain.models.dtos.TarefaDTO;
import br.com.hc.groove.bom.domain.models.entities.Tarefa;
import br.com.hc.groove.bom.domain.models.forms.TarefaForm;
import br.com.hc.groove.bom.domain.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public Page<TarefaDTO> buscarTarefas(Long usuarioId, Pageable paginacao) {
        return tarefaRepository.findByUsuarioId(usuarioId, paginacao).map(TarefaDTO::new);
    }

    public TarefaDTO criarTarefa(TarefaForm tarefaForm) {
        return new TarefaDTO(tarefaRepository.save(new Tarefa(tarefaForm)));
    }
}
