package br.com.phamtecnologia.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientePutDto {

    private Integer idCliente;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String observacoes;
}
