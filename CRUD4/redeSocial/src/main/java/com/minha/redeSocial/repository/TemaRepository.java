package com.minha.redeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minha.redeSocial.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{

}
