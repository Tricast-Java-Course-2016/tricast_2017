package com.tricast.repositories.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATORPERMISSIONMAP")
public class OperatorPermissionMap implements Serializable {

	private static final long serialVersionUID = -155504282719401890L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "operatorid")
	private Long operatorId;

	@Column(name = "permissionid")
	private Long permissionId;

	public Long getId() {
		return id;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public Long getPermissionId() {
		return permissionId;
	}
}
