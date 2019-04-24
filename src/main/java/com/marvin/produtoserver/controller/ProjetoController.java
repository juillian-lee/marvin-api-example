package com.marvin.produtoserver.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvin.produtoserver.domain.ProjetoVO;
import com.marvin.produtoserver.domain.views.ProjetoViews;
import com.marvin.produtoserver.entity.Projeto;
import com.marvin.produtoserver.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	ProjetoService projetoService;

	@PostMapping()
	public ResponseEntity<ProjetoVO> create(final Principal principal,
			@RequestBody @Validated(ProjetoViews.CadastroView.class) final ProjetoVO projetoVO) {
		Projeto projeto = this.projetoService.create(principal, projetoVO);
		ProjetoVO projetoCreated = new ProjetoVO(projeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoCreated);
	}

	@PutMapping()
	public ResponseEntity<ProjetoVO> update(final Principal principal,
			@RequestBody @Validated(ProjetoViews.UpdateView.class) final ProjetoVO projetoVO) {
		this.projetoService.update(principal, projetoVO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping()
	public ResponseEntity<List<ProjetoVO>> findAll(final Principal principal) {
		List<ProjetoVO> projetos = ProjetoVO.fromList(projetoService.list(principal));
		return ResponseEntity.ok(projetos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjetoVO> get(@PathVariable Long id) {
		Projeto projeto = projetoService.get(id);
		return ResponseEntity.ok(new ProjetoVO(projeto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		projetoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
