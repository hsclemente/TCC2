package br.com.hc.groove.bom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hc.groove.bom.services.TarefaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/tarefa")
@SecurityRequirement(name = "bearer-key")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("{usuarioId}")
    public ResponseEntity<?> buscarTarefas(
        Boolean nConcluidos,
        @PathVariable("usuarioId") Long usuarioId,
        @PageableDefault(size = 10, sort = {"dataTarefa"}, direction = Sort.Direction.ASC) Pageable paginacao
    ) {
        return ResponseEntity.ok(tarefaService.buscarTarefas(nConcluidos, usuarioId, paginacao));
    }

}
