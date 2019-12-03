package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Prato;




@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>  {
	Cliente findById(long id);

}
