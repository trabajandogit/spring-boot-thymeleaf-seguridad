package com.bezkoder.spring.thymeleaf.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.bezkoder.spring.thymeleaf.entity.Control;
import com.bezkoder.spring.thymeleaf.entity.Dominio;
import com.bezkoder.spring.thymeleaf.entity.Objetivo;
import com.bezkoder.spring.thymeleaf.repository.ControlRepository;
import com.bezkoder.spring.thymeleaf.repository.DominioRepository;
import com.bezkoder.spring.thymeleaf.repository.ObjetivoRepository; 

@Component
public class SoloRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SoloRunner.class);

    @Autowired
    private DominioRepository dominioRepository; 
    @Autowired
    private ObjetivoRepository objetivoRepository;
    @Autowired
    private ControlRepository controlRepository;

    @Override
    public void run(String... args) throws Exception {
    	try {
    		logger.info("# Dominios encontrados: {}", dominioRepository.count());
    	    logger.info("# Objetivos encontrados: {}", objetivoRepository.count());
    	    logger.info("# Objetivos encontrados: {}", controlRepository.count());
    	} catch (Exception e) {
    		logger.error("Aceder a repositories: "+e.getMessage());
    		logger.error(e.getStackTrace().toString());
    	}
    	//Crear Datos
    	try { 
    		dominioRepository.saveAndFlush(new Dominio("POLÍTICAS DE SEGURIDAD",5));
    		objetivoRepository.saveAndFlush(new Objetivo(5,1,"Directrices de la Dirección en seguridad de la información"));
    		objetivoRepository.saveAndFlush(new Objetivo(5,2,"Director"));
    		controlRepository.saveAndFlush(new Control(5,1,1,"Conjunto de políticas para la seguridad de la información"));
    		controlRepository.saveAndFlush(new Control(5,1,2,"Revisión de las políticas para la seguridad de la información"));
    	}catch (Exception e) {
    		logger.error("Crear Datos: "+e.getMessage());
    		logger.error(e.getStackTrace().toString());    		
    	}
        logger.info("------------------------");
        logger.info("Todos los dominios ordenados ascendentemente por titulo");
        List<Dominio> ordenados = dominioRepository.findAll(Sort.by(Sort.Direction.DESC, "titulo"));
        logger.info("{}", ordenados);
        logger.info("------------------------");
        logger.info("Lista Objetivo y control");
        List <Objetivo> total = objetivoRepository.findAll();
        logger.info("{}", total);
        List <Control> tot = controlRepository.findAll();
        logger.info("{}", tot);      
        logger.info("------------------------");
        logger.info("Borrar Datos");
        //controlRepository.deleteAllInBatch();
        //objetivoRepository.deleteAllInBatch();
        //dominioRepository.deleteAllInBatch();
        logger.info("# Dominios encontrados: {}", dominioRepository.count());
    }
}