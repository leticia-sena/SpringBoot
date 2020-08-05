package com.minha.redeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minha.redeSocial.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

}
