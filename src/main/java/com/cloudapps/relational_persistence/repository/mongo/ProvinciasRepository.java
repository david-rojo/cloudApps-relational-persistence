package com.cloudapps.relational_persistence.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloudapps.relational_persistence.dto.mongo.GroupByComunidadAndCountDTO;
import com.cloudapps.relational_persistence.model.mongo.Provincia;

public interface ProvinciasRepository extends MongoRepository<Provincia, String> {

	@Aggregation(pipeline= {
			"{$sortByCount:'$CA'}",
			"{$project:{'_id':0,'comunidad':'$_id', 'provincias':'$count'}}"})
	List<GroupByComunidadAndCountDTO> groupByComunidadAndCountProvincias(); 
	
}
