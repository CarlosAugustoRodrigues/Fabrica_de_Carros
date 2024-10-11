package senai.atividade.sisfabricadecarros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_alocacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Alocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidade;
    private Long area;

    @OneToOne(fetch = FetchType.EAGER)
    private Automovel automovel;
    @OneToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
    @OneToOne(fetch = FetchType.EAGER)
    private Concessionaria concessionaria;
}
