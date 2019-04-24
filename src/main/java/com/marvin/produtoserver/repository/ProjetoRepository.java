package com.marvin.produtoserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marvin.produtoserver.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	@Query("FROM Projeto p WHERE  p.username = :username")
	List<Projeto> findAll(@Param("username") String username);

}
