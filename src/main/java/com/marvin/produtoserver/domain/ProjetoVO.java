package com.marvin.produtoserver.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.marvin.produtoserver.domain.views.ProjetoViews;
import com.marvin.produtoserver.entity.Projeto;

import lombok.Data;

@Data
public class ProjetoVO implements Serializable {

	private static final long serialVersionUID = 2834594309289943430L;

	@NotNull(groups = ProjetoViews.UpdateView.class)
	@JsonView({ ProjetoViews.GetView.class, ProjetoViews.ListView.class })
	private Long id;

	@NotEmpty(groups = ProjetoViews.CadastroView.class)
	@JsonView({ ProjetoViews.GetView.class, ProjetoViews.ListView.class })
	private String nome;

	@NotNull(groups = ProjetoViews.CadastroView.class)
	@JsonView({ ProjetoViews.GetView.class, ProjetoViews.ListView.class })
	private boolean quitado;

	@NotNull(groups = ProjetoViews.CadastroView.class)
	@JsonView({ ProjetoViews.GetView.class, ProjetoViews.ListView.class })
	private Float valor;
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataCriacao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataAtualizacao;

	public void setValues(Projeto projeto) {
		projeto.setNome(nome);
		projeto.setValor(valor);
		projeto.setQuitado(quitado);
		projeto.setDescricao(descricao);
	}

	public ProjetoVO() {
	}

	public ProjetoVO(Projeto projeto) {
		id = projeto.getId();
		nome = projeto.getNome();
		quitado = projeto.isQuitado();
		valor = projeto.getValor();
		descricao = projeto.getDescricao();
		dataCriacao = projeto.getDataCriacao();
		dataAtualizacao = projeto.getDataAtualizacao();
	}

	public static List<ProjetoVO> fromList(List<Projeto> projetos) {
		return projetos.stream().map(ProjetoVO::new).collect(Collectors.toList());
	}

}
