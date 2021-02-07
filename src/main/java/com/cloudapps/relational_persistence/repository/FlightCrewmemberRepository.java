package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.FlightCrewmember;

public interface FlightCrewmemberRepository extends JpaRepository<FlightCrewmember, Long> {

}
