package com.login.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.model.CurrentUserSession;

@Repository
public interface CurrentSessionDao extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUuid(String uuid);

	@Query("from CurrentUserSession c where c.UserId=?1")
	public Optional<CurrentUserSession> findByUserId(Integer id);
	
}
