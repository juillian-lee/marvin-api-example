package com.marvin.produtoserver.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvin.produtoserver.domain.ProjetoVO;
import com.marvin.produtoserver.entity.Projeto;
import com.marvin.produtoserver.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;
	
	public Projeto create(final Principal principal, ProjetoVO projetoVO) {
		Projeto projeto = new Projeto();
		projetoVO.setValues(projeto);
		projeto.setUsername(principal.getName());
		return projetoRepository.save(projeto);
	}

	public void update(Principal principal, ProjetoVO projetoVO) {
		Projeto projeto = projetoRepository.getOne(projetoVO.getId());
		projetoVO.setValues(projeto);
		projetoRepository.save(projeto);
	}
	
	public Projeto get(Long id) {
		return projetoRepository.getOne(id);
	}
	
	public List<Projeto> list(final Principal principal) {
		return projetoRepository.findAll(principal.getName());
	}
	
	public void delete(Long id) {
		projetoRepository.deleteById(id);
	}
	
}
