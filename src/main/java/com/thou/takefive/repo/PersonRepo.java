package com.thou.takefive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thou.takefive.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
