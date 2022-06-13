/**
 * 
 */
package io.swagger.service.ifc;

import javax.validation.Valid;

import io.swagger.model.VacunaDto;
import io.swagger.util.BusinessException;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public interface IVacunaSvc {

	public VacunaDto postRegistroVacuna(VacunaDto body) throws BusinessException;

}
