package com.produtos.apirest.repository;







import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Prato;




public interface PratoRepository  extends JpaRepository<Prato, Long> {
	Prato findById(long id);
}
