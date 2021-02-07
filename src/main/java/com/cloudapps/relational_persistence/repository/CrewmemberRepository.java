package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Crewmember;

public interface CrewmemberRepository extends JpaRepository<Crewmember, Long> {

}
