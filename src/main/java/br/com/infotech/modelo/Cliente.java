package br.com.infotech.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.infotech.enums.Defeito;
import br.com.infotech.enums.Marca;
import br.com.infotech.enums.Pagamento;
import br.com.infotech.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = " clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHora = LocalDateTime.now();
	private int ordem = new Random().nextInt(1000 + 1);	
	private String nome;
	private String fone;
	private Marca marca;
	private String modelo;
	private Defeito defeito;
	@Column(length = 500)
	private String servico;
	private LocalDate dataEntrega;
	private Double valor;
	private Pagamento pagamento;
	private Status status;
	private int garantiaMes;
	

}
