package com.bezkoder.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bezkoder.spring.thymeleaf.entity.Dominio;
import com.bezkoder.spring.thymeleaf.repository.DominioRepository;

@Controller
public class DominioController {

	  @Autowired
	  private DominioRepository dominioRepository;
	  
	  @GetMapping("/dominios")
	  public String getAll(Model model, @Param("keyword") String keyword) {
	    try {
	      List<Dominio> dominios = new ArrayList<Dominio>();

	      if (keyword == null) {
	        dominioRepository.findAll().forEach(dominios::add);
	      } else {
	        dominioRepository.findByTituloContainingIgnoreCase(keyword).forEach(dominios::add);
	        model.addAttribute("keyword", keyword);
	      }

	      model.addAttribute("dominios", dominios);
	    } catch (Exception e) {
	      model.addAttribute("message", e.getMessage());
	    }

	    return "dominios";
	  }


}
