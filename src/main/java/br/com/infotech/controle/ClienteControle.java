package br.com.infotech.controle;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.infotech.dto.ClienteDto;

import br.com.infotech.servico.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("assistencia")
@RequiredArgsConstructor
public class ClienteControle {
	
	private final ClienteServico clienteServico;
	
	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de clientes e serviço") 
    @ApiResponse(responseCode = "201",description = "voluntário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDto>criar(@RequestBody @Valid ClienteDto cliente){
		var criarCliente = clienteServico.criar(cliente);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{id}").buildAndExpand(criarCliente.getId()).toUri();	
		return ResponseEntity.created(uri).body(new ClienteDto(criarCliente));
				
	}
	
	@GetMapping("busca/{ordem}")
	@Operation(summary = "Rota responsável pela busca de cliente e serviço pela ordem de serviço")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<ClienteDto>buscarPorOrdem(@PathVariable int ordem){
		var busca = clienteServico.buscarPorNumero(ordem);
		return ResponseEntity.ok().body(new ClienteDto(busca));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os clientes e serviços")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<ClienteDto>>buscarTodos(){
		var buscarTodos = clienteServico.buscarTodos();
		return ResponseEntity.ok(buscarTodos);
	}
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca de cliente e serviço pelo id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<ClienteDto>buscarPorId(@PathVariable Long id){
		var buscaId = clienteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new ClienteDto(buscaId));
	}
	
	@PutMapping
	@Operation(summary = "Rota responsável pela atualização de clientes e serviços")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<ClienteDto>atualizarCliente(@RequestBody @Valid ClienteDto cliente,@PathVariable Long id){
		var  atualizar = clienteServico.atualizarCliente(cliente, id);
		return ResponseEntity.ok().body(new ClienteDto(atualizar));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar um cliente e serviço pelo id")
	@ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		clienteServico.excluir(id);
		return ResponseEntity.noContent().build();
	}
}