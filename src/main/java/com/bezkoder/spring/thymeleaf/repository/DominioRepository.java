package com.bezkoder.spring.thymeleaf.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.thymeleaf.entity.Dominio;

@Transactional
public interface DominioRepository extends JpaRepository<Dominio, Integer> {

}
