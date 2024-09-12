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
public class ClientePostDto {

    private String nome;
    private String cpf;
    private String emai;
    private String telefone;
    private String observacoes;

}
