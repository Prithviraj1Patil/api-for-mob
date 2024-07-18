package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.SystemConfiguration;

public interface SystemConfigurationRepo extends JpaRepository<SystemConfiguration, Long> {

}
