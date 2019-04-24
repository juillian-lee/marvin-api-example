package com.marvin.produtoserver.entity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "projeto", indexes = @Index(columnList = "username"))
public class Projeto extends BaseEntity {

	private static final long serialVersionUID = -2436271821482921120L;

	private String nome;
	private Float valor;
	private boolean quitado;
	private String username;
	private String descricao;
}
