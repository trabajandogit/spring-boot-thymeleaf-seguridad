package com.bezkoder.spring.thymeleaf.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.thymeleaf.entity.Control;

@Transactional
public interface ControlRepository extends JpaRepository<Control, com.bezkoder.spring.thymeleaf.entity.ControlPK> {

}