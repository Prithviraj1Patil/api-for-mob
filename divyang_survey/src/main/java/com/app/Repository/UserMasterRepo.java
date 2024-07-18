package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster, Long> {

	Optional<UserMaster> findByUsmUserName(String usmUserName);
}