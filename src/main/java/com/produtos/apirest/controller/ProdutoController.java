package com.produtos.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.produtos.apirest.models.Prato;
import com.produtos.apirest.resources.PratoResource;







@Controller
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private PratoResource pratoResource;
	@RequestMapping("/CadastroProduto")
	public ModelAndView formularioProduto() {
		ModelAndView mv = new ModelAndView("CadastroProduto");
		mv.addObject("prato", new Prato());
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("produtos",pratoResource.listarProduto());
		return "ListagemProduto";
	}
	@PostMapping("/salvar")
	public ModelAndView salvarPessoa(Prato prato) {
		pratoResource.salvaProduto(prato);
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarProduto() {
		List<Prato> pratos = pratoResource.listarProduto();
		ModelAndView mv = new ModelAndView("ListagemProduto");
		mv.addObject("todosOsProdutos", pratos);
		return mv;
	}
//	@RequestMapping("{id}")
//	public ModelAndView atualizarProduto(@PathVariable Long id) {
//	//	Prato prato = pratoResource.atualizaProduto(prato.getId());
	//	ModelAndView mv = new ModelAndView("CadastroProduto");
//		mv.addObject("produto", prato);
	//	
	//	return mv;
	//}
	
//	@RequestMapping("/excluir/{id}")
//	public ModelAndView excluirProduto(@PathVariable Long id) {
//		pratoResource.deletaProduto(produto);
//		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
//		return mv;
//	}
	
	
	

}
