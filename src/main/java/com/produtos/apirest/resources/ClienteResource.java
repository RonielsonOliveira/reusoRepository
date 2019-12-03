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

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Prato;

import com.produtos.apirest.repository.ClienteRepository;
import com.produtos.apirest.repository.PratoRepository;

import io.swagger.annotations.ApiOperation;





@RestController
@RequestMapping(value="/api")
public class ClienteResource {

	@Autowired
    ClienteRepository clienteRepository;
    PratoRepository pratoRepository;
	@GetMapping("/cliente")
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}
	@ApiOperation(value="Retorna um cliente unico")
	@GetMapping("/cliente/{id}")
	public Cliente listaClienteUnico(@PathVariable(value="id") long id){
		return clienteRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um cliente")
	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@ApiOperation(value="Deleta um cliente")
	@DeleteMapping("/cliente")
	public void deletaProduto(@RequestBody @Valid Cliente cliente ) {
		clienteRepository.delete(cliente);
	}
	
	@ApiOperation(value="Atualiza um produto")
	@PutMapping("/cliente")
	public Cliente atualizaProduto(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	

	
	
}
