package com.tricast.managers;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tricast.controllers.responses.PlayerResponse;
import com.tricast.repositories.PlayerRepository;
import com.tricast.repositories.entities.Player;
import com.tricast.repositories.entities.embded.Username;

@Service
public class PlayerManagerImpl implements PlayerManager {

    private PlayerRepository playerRepository;

    private final PasswordEncoder encoder;
    
    @Inject
    public PlayerManagerImpl(PlayerRepository playerRepository, PasswordEncoder encoder) {
        this.playerRepository = playerRepository;
        this.encoder = encoder;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.delete(id);
    }

	@Override
	public PlayerResponse login(String username, String password) throws SQLException {
		
		Player foundPlayerEntity = playerRepository.findByUserName(username);

		if (foundPlayerEntity == null || !encoder.matches(password, foundPlayerEntity.getPassword())) {
			throw new SQLException("Wrong username or password: " + username);
		}

		return buildPlayerResponse(foundPlayerEntity);
		
	}

	private PlayerResponse buildPlayerResponse(Player entity) {
		
		PlayerResponse response = new PlayerResponse();
		
		response.setAddress(entity.getAddress());
		response.setCity(entity.getCity());
		response.setCountry(entity.getCountry());
		response.setDob(entity.getDob());
		response.setEmail(entity.getEmail());
		response.setFirstName(entity.getFirstName());
		response.setId(entity.getId());
		response.setIdentityCardNumber(entity.getIdentityCardNumber());
		response.setLastName(entity.getLastName());
		response.setPhoneNumber(entity.getPhoneNumber());
		response.setSex(entity.getSex());
		response.setUserName(entity.getUserName());
		response.setZipcode(entity.getZipcode());
		
		return response;
	}
}
