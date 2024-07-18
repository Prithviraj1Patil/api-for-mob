package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Entity.FieldConfigMaster;

public interface FieldConfigMasterRepo extends JpaRepository<FieldConfigMaster, Long> {

	@Query(value="select * from vw_all_fields",nativeQuery = true)
	List<Object[]> getallFieldList(); 
}
