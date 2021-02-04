package com.cloudapps.persistencia_relacional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.persistencia_relacional.repository.AeropuertoRepository;
import com.cloudapps.persistencia_relacional.repository.AvionRepository;
import com.cloudapps.persistencia_relacional.repository.EmpleadoRepository;
import com.cloudapps.persistencia_relacional.repository.MecanicoRepository;
import com.cloudapps.persistencia_relacional.repository.RevisionRepository;
import com.cloudapps.persistencia_relacional.repository.TripulanteRepository;
import com.cloudapps.persistencia_relacional.repository.VueloRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private AeropuertoRepository aeropuertoRepository;
	
	@Autowired
	private AvionRepository avionRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private MecanicoRepository mecanicoRepository;
	
	@Autowired
	private RevisionRepository revisionRepository;
	
	@Autowired
	private TripulanteRepository tripulanteRepository;
	
	@Autowired
	private VueloRepository vueloRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Pending to implement
		
	}

}
