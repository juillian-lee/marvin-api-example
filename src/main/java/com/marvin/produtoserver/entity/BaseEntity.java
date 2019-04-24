package com.marvin.produtoserver.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -231221413316676254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	@EqualsAndHashCode.Include
	private Long id;

	private Date dataCriacao;

	private Date dataAtualizacao;

	@PreUpdate
	@PrePersist
	private void saveOrUpdate() {
		this.dataAtualizacao = new Date();
		if (this.dataCriacao == null) {
			this.dataCriacao = new Date();
		}
	}

}
