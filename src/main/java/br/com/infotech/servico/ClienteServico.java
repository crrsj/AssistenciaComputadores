package br.com.infotech.servico;

import java.util.List;
import java.util.Optional;

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
	
	public List<ClienteDto>buscarTodos(){
		var lista = clienteRepositorio.findAll().
		stream().map(ClienteDto::new).toList();
		return lista;
	}

	public Cliente buscarPorId(Long id) {
		Optional<Cliente>buscar = clienteRepositorio.findById(id);
		return buscar.get();
	}
	
	public Cliente atualizarCliente(ClienteDto cliente) {		
		var atualizar = new Cliente(cliente);
		return clienteRepositorio.save(atualizar);
		
	}
	public void excluir(Long id) {
		clienteRepositorio.deleteById(id);
	}
}
