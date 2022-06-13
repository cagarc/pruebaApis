/**
 * 
 */
package io.swagger.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.VacunaDto;
import io.swagger.repository.ifc.IVacunaRepo;
import io.swagger.repository.model.Vacuna;
import io.swagger.service.ifc.IVacunaSvc;
import io.swagger.util.ConvertApis;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */

@Service
public class VacunaImplSvc implements IVacunaSvc {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VacunaImplSvc.class);
	
	@Autowired
	IVacunaRepo repository;

	@Override
	public VacunaDto postRegistroVacuna(VacunaDto body) {
		// TODO Auto-generated method stub
		LOGGER.info(" PROCESO INICIO: postRegistroVacuna " + body);
		Vacuna emplea = repository.save(ConvertApis.dtoToModel(body));
		LOGGER.info(" PROCESO FIN: postRegistroVacuna : PROCESO INGESO EXITOSO");
		return ConvertApis.modelToDto(emplea);
	}

}
