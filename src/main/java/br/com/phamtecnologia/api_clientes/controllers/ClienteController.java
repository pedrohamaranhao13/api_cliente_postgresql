package br.com.phamtecnologia.api_clientes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<String> post(@RequestBody ClientePostDto dto) {
        
        try {
            
            Cliente cliente = new Cliente();
            cliente.setNome(dto.getNome());
            cliente.setCpf(dto.getCpf());
            cliente.setEmail(dto.getEmai());
            cliente.setTelefone(dto.getTelefone());
            cliente.setObservacoes(dto.getObservacoes());

            ClienteRepository clienteRepository = new ClienteRepository();
            clienteRepository.create(cliente);

            return ResponseEntity.status(200).body("Cliente cadastrado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro " + e.getMessage());
        } 
    }

    @PutMapping
	public ResponseEntity<String> put(@RequestBody ClientePutDto dto) {
		
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
				
				return ResponseEntity.status(200).body("Cliente atualizado com sucesso!");
			} 
			else {
				return ResponseEntity.status(400).body("Cliente não encontrado.");
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro :" + e.getMessage());
		}
		
	}

    @DeleteMapping("{idCliente}")
    public ResponseEntity<String> delete(@PathVariable("idCliente") Integer idCliente) {
        
        try {
            
            ClienteRepository clienteRepository = new ClienteRepository();
            Cliente cliente = clienteRepository.findById(idCliente);

            if (cliente != null) {
                
                clienteRepository.delete(cliente);
                return ResponseEntity.status(200).body("Cliente excluído com sucesso!");
            }
            else {
                return ResponseEntity.status(400).body("Cliente não encontrado.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }

    }

    @GetMapping
    public List<Cliente> getAll() {
        
        try {
            ClienteRepository clienteRepository = new ClienteRepository();
            return clienteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("{idCliente}")
    public Cliente findById(@PathVariable("idCliente") Integer idCliente) {

        try {
            ClienteRepository clienteRepository = new ClienteRepository();
            return clienteRepository.findById(idCliente);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
