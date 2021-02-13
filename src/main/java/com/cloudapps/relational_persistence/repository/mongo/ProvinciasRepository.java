package com.cloudapps.relational_persistence.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloudapps.relational_persistence.dto.mongo.GroupByComunidadAndCountDTO;
import com.cloudapps.relational_persistence.model.mongo.Provincia;

public interface ProvinciasRepository extends MongoRepository<Provincia, String> {

	@Aggregation(pipeline= {
			"{$group:{_id: '$CA','suma': { '$sum': 1 }}}",
			"{$project:{'_id':0,'comunidad':'$_id', 'provincias':'$suma'}}"})
	List<GroupByComunidadAndCountDTO> groupByComunidadAndCountProvincias(); 
	
}
