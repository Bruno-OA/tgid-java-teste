package br.com.tgid.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo não informado")
    private String nome;

    @NotBlank(message = "Campo não informado")
    @CPF(message = "Formato do CPF incorreto")
    private String cpf;

    @NotBlank(message = "Campo não informado")
    private String telefone;

    @NotBlank(message = "Campo não informado")
    @Email(message = "Formato do email incorreto")
    private String email;

}