package br.com.infotech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infotech.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
