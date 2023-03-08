package com.bezkoder.spring.thymeleaf.restfullcontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.thymeleaf.entity.Dominio;
import com.bezkoder.spring.thymeleaf.repository.DominioRepository;
 
@RestController
@RequestMapping("/api")
public class DominioRestController  {
	DominioRepository  dominioRepository;
 
    //@Autowired
    public DominioRestController(DominioRepository dominioRepository){
        this.dominioRepository = dominioRepository;
    }
 
    // GET /api/dominios
    @GetMapping("/dominios")
    public Iterable<Dominio> findAll(){
        List<Dominio> dominios = new ArrayList<>();
        Iterator<Dominio> iterator = dominioRepository.findAll().iterator();
        iterator.forEachRemaining(dominios::add);
        Collections.reverse(dominios);
        return dominios;
    }

}
