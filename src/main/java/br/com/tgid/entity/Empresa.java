package br.com.tgid.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo não informado")
    private String nome;
    @NotBlank(message = "Campo não informado")
    @CNPJ(message = "Formato do CNPJ incorreto")
    private String cnpj;
}
