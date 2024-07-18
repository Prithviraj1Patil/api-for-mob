package com.app.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Questions;

public interface QuestionRepo extends JpaRepository<Questions, Long> {

}
