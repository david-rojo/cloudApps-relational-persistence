package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Crewmember;

public interface CrewMemberRepository extends JpaRepository<Crewmember, Long> {

}
