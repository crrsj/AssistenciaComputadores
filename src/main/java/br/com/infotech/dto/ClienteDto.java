package br.com.infotech.dto;

import java.time.LocalDate;

import br.com.infotech.enums.Defeito;
import br.com.infotech.enums.Marca;
import br.com.infotech.enums.Pagamento;
import br.com.infotech.enums.Status;

public record ClienteDto(
              
                Long id,
                
                String nome,
                
                String fone,
                
                Marca marca,
                
                String modelo, 
                
		        Defeito defeito,
		         
		        String servico, 
		      
		        LocalDate dataEntrega,
		       
		        Double valor,
		        
		        Pagamento pagamento,
		        
		        Status status,
		        
		        int garantiaMes) {
		                                                                        

}
