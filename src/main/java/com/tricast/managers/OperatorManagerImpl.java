package com.tricast.managers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tricast.controllers.responses.OperatorResponse;
import com.tricast.controllers.responses.PlayerResponse;
import com.tricast.repositories.OperatorPermissionMapRepository;
import com.tricast.repositories.OperatorRepository;
import com.tricast.repositories.entities.Operator;
import com.tricast.repositories.entities.OperatorPermissionMap;
import com.tricast.repositories.entities.Player;

@Service
public class OperatorManagerImpl implements OperatorManager {

	private OperatorRepository operatorRepository;
	private OperatorPermissionMapRepository operatorPermissionMapRepository;

	private final PasswordEncoder encoder;

	@Inject
	public OperatorManagerImpl(OperatorRepository operatorRepository, PasswordEncoder encoder,
			OperatorPermissionMapRepository operatorPermissionMapRepository) {
		this.operatorRepository = operatorRepository;
		this.operatorPermissionMapRepository = operatorPermissionMapRepository;
		this.encoder = encoder;
	}

	@Override
	public List<Operator> findAll() {
		return operatorRepository.findAll();
	}

	@Override
	public Operator findById(Long id) {
		return operatorRepository.findById(id);
	}

	@Override
	public Operator create(Operator player) {
		return operatorRepository.save(player);
	}

	@Override
	public Operator update(Operator player) {
		return operatorRepository.save(player);
	}

	@Override
	public void deleteById(Long id) {
		operatorRepository.delete(id);
	}

	@Override
	public OperatorResponse login(String username, String password) throws SQLException {

		Operator foundOperatorEntity = operatorRepository.findByUserName(username);

		if (foundOperatorEntity == null || !encoder.matches(password, foundOperatorEntity.getPassword())) {
			throw new SQLException("Wrong username or password: " + username);
		}

		List<OperatorPermissionMap> permissions = operatorPermissionMapRepository
				.findByOperatorId(foundOperatorEntity.getId());
		
		return buildOperatorResponse(foundOperatorEntity, permissions);

	}

	private OperatorResponse buildOperatorResponse(Operator entity, List<OperatorPermissionMap> permissions) {

		OperatorResponse response = new OperatorResponse();

		response.setAddress(entity.getAddress());
		response.setCountry(entity.getCountry());
		response.setEmail(entity.getEmail());
		response.setFirstName(entity.getFirstName());
		response.setId(entity.getId());
		response.setLastName(entity.getLastName());
		response.setPhoneNumber(entity.getPhoneNumber());
		response.setSex(entity.getSex());
		response.setUserName(entity.getUserName());
		response.setZipcode(entity.getZipcode());

		List<Long> permissionIds = new ArrayList<>();
		permissions.forEach(p -> permissionIds.add(p.getPermissionId()));
		response.setPermissionIds(permissionIds);
			
		return response;
	}
}
