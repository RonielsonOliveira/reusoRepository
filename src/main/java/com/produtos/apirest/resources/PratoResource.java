package com.produtos.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Prato;

import com.produtos.apirest.repository.PratoRepository;

import io.swagger.annotations.ApiOperation;





@RestController
@RequestMapping(value="/api")
public class PratoResource {

	@Autowired
    PratoRepository pratoRepository;

	
	
	@GetMapping("/pratos")
	public List<Prato> listarProduto() {
		return pratoRepository.findAll();
	}
	@ApiOperation(value="Retorna um produto unico")
	@GetMapping("/prato/{id}")
	public Prato listaProdutoUnico(@PathVariable(value="id") long id){
		return pratoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um produto")
	@PostMapping("/prato")
	public Prato salvaProduto(@RequestBody @Valid Prato prato) {
		return pratoRepository.save(prato);
	}
	
	@ApiOperation(value="Deleta um produto")
	@DeleteMapping("/prato")
	public void deletaProduto(@RequestBody @Valid Prato produto) {
		pratoRepository.delete(produto);
	}
	
	@ApiOperation(value="Atualiza um produto")
	@PutMapping("/prato")
	public Prato atualizaProduto(@RequestBody @Valid Prato prato) {
		return pratoRepository.save(prato);
	}

	
	

	
	
}
