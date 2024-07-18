package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.EmployeeMaster;

public interface EmployeeMasterRepo extends JpaRepository<EmployeeMaster, Long> {

}
