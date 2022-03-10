package com.thou.takefive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thou.takefive.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	
	// Return Random Task
	@Query(value = "SELECT * FROM task ORDER BY rand() LIMIT 1", nativeQuery = true)
	public Task doRandomTask();
	
}
