package com.example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpa extends JpaRepository<Task, Long>{

	Optional<Task> findByTaskName(String taskName);
	
}
