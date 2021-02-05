package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.CrewMember;

public interface RevisionRepository extends JpaRepository<CrewMember, String> {

}
