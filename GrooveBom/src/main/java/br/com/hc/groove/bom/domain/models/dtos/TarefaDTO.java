package br.com.hc.groove.bom.domain.models.dtos;

import java.time.LocalDateTime;

import br.com.hc.groove.bom.domain.models.entities.Tarefa;

public record TarefaDTO(Long id, String titulo, String descricao, LocalDateTime dataTarefa, Boolean concluido, Long usuarioId) {
    public TarefaDTO(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataTarefa(), tarefa.getConcluido(), tarefa.getUsuarioId());
    }
}
