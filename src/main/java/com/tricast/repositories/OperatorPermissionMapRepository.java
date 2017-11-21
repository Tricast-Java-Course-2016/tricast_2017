package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.Operator;
import com.tricast.repositories.entities.OperatorPermissionMap;

public interface OperatorPermissionMapRepository extends CrudRepository<OperatorPermissionMap, Long> {

	@Override
    List<OperatorPermissionMap> findAll();

	OperatorPermissionMap findById(Long id);

	List<OperatorPermissionMap> findByOperatorId(Long operatorId);
}