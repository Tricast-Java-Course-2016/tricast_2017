package com.tricast.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tricast.repositories.entities.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

	@Override
	List<Player> findAll();

	Player findById(Long id);

	Player findByUserName(String username);
}