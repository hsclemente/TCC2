package br.com.hc.groove.bom.domain.models.entities;

import java.time.LocalDateTime;

import br.com.hc.groove.bom.domain.models.forms.SaldoForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "gb_saldos")
@AllArgsConstructor@NoArgsConstructor
public class Saldo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "id_externo")
    private Long idExterno;

    @Column(name = "data_movimentacao")
    private LocalDateTime data;

    @PrePersist
    void create() {
        this.data = LocalDateTime.now();
    }

    public Saldo(SaldoForm saldoForm) {
        this.descricao = saldoForm.descricao();
        this.idExterno = saldoForm.idExterno();
    }
}
