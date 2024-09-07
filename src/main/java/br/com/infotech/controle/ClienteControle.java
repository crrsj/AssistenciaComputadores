package br.com.infotech.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.infotech.dto.ClienteDto;

import br.com.infotech.servico.ClienteServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("assistencia")
@RequiredArgsConstructor
public class ClienteControle {
	
	private final ClienteServico clienteServico;
	
	@PostMapping
	public ResponseEntity<ClienteDto>criar(@RequestBody @Valid ClienteDto cliente){
		var criarCliente = clienteServico.criar(cliente);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{id}").buildAndExpand(criarCliente.getId()).toUri();	
		return ResponseEntity.created(uri).body(new ClienteDto(criarCliente));
				
	}
	
	@GetMapping("busca/{ordem}")
	public ResponseEntity<ClienteDto>buscarPorOrdem(@PathVariable int ordem){
		var busca = clienteServico.buscarPorNumero(ordem);
		return ResponseEntity.ok().body(new ClienteDto(busca));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>>buscarTodos(){
		var buscarTodos = clienteServico.buscarTodos();
		return ResponseEntity.ok(buscarTodos);
	}
	@GetMapping("{id}")
	public ResponseEntity<ClienteDto>buscarPorId(@PathVariable Long id){
		var buscaId = clienteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new ClienteDto(buscaId));
	}
	
	@PutMapping
	public ResponseEntity<ClienteDto>atualizarCliente(@RequestBody @Valid ClienteDto cliente,@PathVariable Long id){
		var  atualizar = clienteServico.atualizarCliente(cliente, id);
		return ResponseEntity.ok().body(new ClienteDto(atualizar));
	}
	
	
}