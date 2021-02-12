package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Revision;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface RevisionRepository extends JpaRepository<Revision, Long> {

}
