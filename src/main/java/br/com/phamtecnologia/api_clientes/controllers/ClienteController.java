package br.com.phamtecnologia.api_clientes.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.dtos.ClientePostDto;
import br.com.phamtecnologia.dtos.ClientePutDto;
import br.com.phamtecnologia.entities.Cliente;
import br.com.phamtecnologia.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @PostMapping
    public String post(@RequestBody ClientePostDto dto) {
        
        try {
            
            Cliente cliente = new Cliente();
            cliente.setNome(dto.getNome());
            cliente.setCpf(dto.getCpf());
            cliente.setEmail(dto.getEmai());
            cliente.setTelefone(dto.getTelefone());
            cliente.setObservacoes(dto.getObservacoes());

            ClienteRepository clienteRepository = new ClienteRepository();
            clienteRepository.create(cliente);

            return "Cliente cadastrado com sucesso.";
        } catch (Exception e) {
            return "Erro " + e.getMessage();
        } 
    }

    @PutMapping
	public String put(@RequestBody ClientePutDto dto) {
		
		try {
			
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(dto.getIdCliente());
			
			if (cliente != null) {
				
				cliente.setNome(dto.getNome());
				cliente.setEmail(dto.getEmail());
				cliente.setCpf(dto.getCpf());
				cliente.setTelefone(dto.getTelefone());
				cliente.setObservacoes(dto.getObservacoes());
				
				clienteRepository.update(cliente);
				
				return "Cliente atualizado com sucesso!";
			} 
			else {
				return "Cliente não encontrado.";
			}
			
			
		} catch (Exception e) {
			return "Erro :" + e.getMessage();
		}
		
	}

    @DeleteMapping
    public String delete() {
        //TODO
        return null;
    }

    @GetMapping
    public String getAll() {
        //TODO
        return null;
    }
}
