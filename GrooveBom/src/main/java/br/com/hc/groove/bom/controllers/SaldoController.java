package br.com.hc.groove.bom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hc.groove.bom.domain.models.dtos.SaldoDTO;
import br.com.hc.groove.bom.domain.models.forms.SaldoForm;
import br.com.hc.groove.bom.services.SaldoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/saldo")
@SecurityRequirement(name = "bearer-key")
public class SaldoController {
    
    @Autowired
    private SaldoService saldoService;
    
    @GetMapping("/{idExterno}")
    public ResponseEntity<?> buscarSaldos(
        @PageableDefault(size = 10, sort = {"data"}, direction = Sort.Direction.DESC) Pageable paginacao,
        @PathVariable("idExterno") Long idExterno) {
        return ResponseEntity.ok(saldoService.buscarSaldos(idExterno, paginacao));
    }

    @PostMapping
    public ResponseEntity<?> criarSaldo(@RequestBody@Valid SaldoForm form, UriComponentsBuilder uriBuilder) {
        Long id = saldoService.criarSaldo(form);
        return ResponseEntity.created(uriBuilder.path("/saldo/{id}").buildAndExpand(id).toUri()).body(id);
    }
}
