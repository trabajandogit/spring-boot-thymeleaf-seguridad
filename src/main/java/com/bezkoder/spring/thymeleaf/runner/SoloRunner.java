package com.bezkoder.spring.thymeleaf.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.bezkoder.spring.thymeleaf.entity.Dominio;
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
    		logger.error("Objetivos: "+e.getMessage());
    		logger.error(e.getStackTrace().toString());
    	}
    	
    	
        logger.info("Dominios en desorden:");
        List<Dominio> dominios = dominioRepository.findAll();
        logger.info("{}", dominios);
        logger.info("------------------------");
        logger.info("Todos los dominios ordenados ascendentemente por titulo");
        List<Dominio> ordenados = dominioRepository.findAll(Sort.by(Sort.Direction.DESC, "titulo"));
        logger.info("{}", ordenados);
        logger.info("------------------------");
        logger.info("Borrar dominios");
        //dominioRepository.deleteAllInBatch();
        logger.info("# Dominios encontrados: {}", dominioRepository.count());
    }
}