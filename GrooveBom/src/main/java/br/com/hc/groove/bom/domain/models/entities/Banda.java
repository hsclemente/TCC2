package br.com.hc.groove.bom.domain.models.entities;

import br.com.hc.groove.bom.domain.models.forms.BandaForm;
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

@Data
@Entity
@Table(name = "gb_bandas")
@AllArgsConstructor@NoArgsConstructor
public class Banda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(name = "saldo", nullable = true)
    private Double saldo;

    @PrePersist
    public void create() {
        this.id = null;
        this.saldo = 0.00;
    }

    public Banda(BandaForm bandaForm) {
        this.nome = bandaForm.nome();
    }
}
