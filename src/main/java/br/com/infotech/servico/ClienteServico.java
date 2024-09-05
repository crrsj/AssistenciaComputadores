package br.com.infotech.servico;

import org.springframework.stereotype.Service;

import br.com.infotech.dto.ClienteDto;
import br.com.infotech.modelo.Cliente;
import br.com.infotech.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServico {
	
	private final ClienteRepositorio clienteRepositorio;
	
	public Cliente criar(ClienteDto cliente) {
		var criarCliente = new Cliente(cliente);
		return clienteRepositorio.save(criarCliente);
		
	}
	
	

}
