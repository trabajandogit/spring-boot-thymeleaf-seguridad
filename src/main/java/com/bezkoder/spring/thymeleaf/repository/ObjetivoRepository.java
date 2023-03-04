package com.bezkoder.spring.thymeleaf.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.thymeleaf.entity.ObjetivoPK;
import com.bezkoder.spring.thymeleaf.entity.Objetivo;

@Transactional
public interface ObjetivoRepository extends JpaRepository<Objetivo, ObjetivoPK> {

}