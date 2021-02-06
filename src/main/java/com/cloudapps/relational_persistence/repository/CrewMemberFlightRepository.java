package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.FlightCrewmember;

public interface CrewMemberFlightRepository extends JpaRepository<FlightCrewmember, Long> {

}
