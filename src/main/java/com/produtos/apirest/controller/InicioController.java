package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.produtos.apirest.models.Prato;
import com.produtos.apirest.resources.PratoResource;


@Controller

public class InicioController {
	@Autowired
	private PratoResource pratoResource;
	@RequestMapping("/inicio")
	public ModelAndView paginaInicial() {
		List<Prato> pratos = pratoResource.listarProduto();
		ModelAndView mv = new ModelAndView("ListagemProduto");
		mv.addObject("todosOsProdutos", pratos);
		return mv;
	}
	

}
