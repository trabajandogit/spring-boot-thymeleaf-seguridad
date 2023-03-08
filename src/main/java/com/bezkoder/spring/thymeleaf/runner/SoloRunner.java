package com.bezkoder.spring.thymeleaf.runner;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    RestTemplate getresttemplate() {
        return new RestTemplate();
    }

    
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
    	if (controlRepository.count()<=0) {
	    	try { 
	    		dominioRepository.saveAndFlush(new Dominio("POLÍTICAS DE SEGURIDAD",5));
	    		dominioRepository.saveAndFlush(new Dominio("ASPECTOS ORGANIZATIVOS DE LA SEGURIDAD DE LA INFORMACION",6));
	    		objetivoRepository.saveAndFlush(new Objetivo(5,1,"Directrices de la Dirección en seguridad de la información"));
	    		objetivoRepository.saveAndFlush(new Objetivo(6,1,"Organización interna"));
	    		objetivoRepository.saveAndFlush(new Objetivo(6,2,"Dispositivos para movilidad y teletrabajo"));
	    		controlRepository.saveAndFlush(new Control(5,1,1,"Conjunto de políticas para la seguridad de la información"));
	    		controlRepository.saveAndFlush(new Control(5,1,2,"Revisión de las políticas para la seguridad de la información"));
	    		controlRepository.saveAndFlush(new Control(6,1,1,"Asignación de responsabilidades para la seguridad de la información"));
	    		controlRepository.saveAndFlush(new Control(6,1,2,"Segregación de tareas"));
	    		controlRepository.saveAndFlush(new Control(6,1,3,"Contacto con las autoridades"));
	    		controlRepository.saveAndFlush(new Control(6,1,4,"Contacto con grupos de interés especial"));
	    		controlRepository.saveAndFlush(new Control(6,1,5,"Seguridad de la información en la gestión de proyectos"));
	    		controlRepository.saveAndFlush(new Control(6,2,1,"Política de uso de dispositivos para movilidad"));
	    		controlRepository.saveAndFlush(new Control(6,2,2,"Teletrabajo"));
	    	}catch (Exception e) {
	    		logger.error("Crear Datos: "+e.getMessage());
	    		logger.error(e.getStackTrace().toString());    		
	    	}
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
        logger.info("------------------------");
        logger.info("Probar Servicio Rest");
        ResponseEntity<Dominio[]>  mov = RestTemplate.getForEntity(
                "http://localhost:8080/api/dominios/",
                Dominio[].class);
        List<ResponseEntity<Dominio[]>> m = Arrays.asList(mov);
        logger.info(m.toString());
    }
}