package br.com.infotech.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.infotech.enums.Defeito;
import br.com.infotech.enums.Marca;
import br.com.infotech.enums.Pagamento;
import br.com.infotech.enums.Status;
import br.com.infotech.modelo.Cliente;

public record ClienteDto(
              
                Long id,
                
                LocalDateTime dataHora,
                
                int ordem,
                
                String nome,
                
                String fone,
                
                Marca marca,
                
                String modelo, 
                
		        Defeito defeito,
		         
		        String servico, 
		        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
		        LocalDate dataEntrega,
		       
		        Double valor,
		        
		        Pagamento pagamento,
		        
		        Status status,
		        
		        int garantiaMes) {

	public ClienteDto(Cliente criarCliente) {
		this(
				criarCliente.getId(),
				criarCliente.getDataHora(),
				criarCliente.getOrdem(),
				criarCliente.getNome(),
				criarCliente.getFone(),
				criarCliente.getMarca(),
				criarCliente.getModelo(),
				criarCliente.getDefeito(),
				criarCliente.getServico(),
				criarCliente.getDataEntrega(),
				criarCliente.getValor(),
				criarCliente.getPagamento(),
				criarCliente.getStatus(),
				criarCliente.getGarantiaMes());
	}
		                                                                        

}
