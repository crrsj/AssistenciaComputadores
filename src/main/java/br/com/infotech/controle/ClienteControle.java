package br.com.infotech.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.infotech.dto.ClienteDto;

import br.com.infotech.servico.ClienteServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("assistencia")
@RequiredArgsConstructor
public class ClienteControle {
	
	private final ClienteServico clienteServico;
	
	@PostMapping
	public ResponseEntity<ClienteDto>criar(@RequestBody ClienteDto cliente){
		var criarCliente = clienteServico.criar(cliente);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{id}").buildAndExpand(criarCliente.getId()).toUri();	
		return ResponseEntity.created(uri).body(new ClienteDto(criarCliente));
				
	}
	
	
}