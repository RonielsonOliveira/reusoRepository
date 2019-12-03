package com.produtos.apirest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.resources.ClienteResource;


@Controller
@RequestMapping("/pessoa")
public class ClienteController {
	
	@Autowired
	private ClienteResource clienteResource;
	
	@RequestMapping("/formulario")
	public ModelAndView formularioCliente() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarPessoa(Cliente cliente) {
		
		clienteResource.salvaCliente(cliente);
		
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarClientes() {
		List<Cliente> clientes = clienteResource.listarCliente();
		ModelAndView mv = new ModelAndView("pagina-listagem");
		
		mv.addObject("todasAsPessoas", clientes);
		
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView atualizarCliente(@PathVariable Long id) {
		Cliente cliente = clienteResource.listaClienteUnico(id); 
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirCliente(@PathVariable Long id) {
	
	
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		return mv;
	}
	
	@RequestMapping("/logar")
	public ModelAndView logar(Cliente c,HttpSession session) {
		session.setAttribute("user", c.getNomeCliente());
        session.setAttribute("userid",c.getId());
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}


	    @RequestMapping("/logout")
	      public String logout(HttpSession session ) {
	         session.invalidate();
	         return "redirect:/login.html";
	      }
	
	

	
	
	
	
	
	
	
	
	

}
