package com.thou.takefive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thou.takefive.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
