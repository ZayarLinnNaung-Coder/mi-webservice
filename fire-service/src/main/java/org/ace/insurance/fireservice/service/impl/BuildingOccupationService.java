package org.ace.insurance.fireservice.service.impl;

import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.BuildingOccupation;
import org.ace.insurance.fireservice.repository.BuildingOccupationRepo;
import org.ace.insurance.fireservice.service.IBuildingOccupationService;
import org.ace.insurance.utilityservice.enumeration.InsuranceType;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingOccupationService  implements IBuildingOccupationService {

	private final BuildingOccupationRepo buildingOccupationRepo;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<BuildingOccupation> findAllBuildingOccupation() {
		List<BuildingOccupation> result = null;
		try {
			result = buildingOccupationRepo.findAll();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find all of BuildingOccupation)", e);
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public BuildingOccupation findBuildingOccupationById(String id) {
		BuildingOccupation result = null;
		try {
			result = buildingOccupationRepo.findById(id).get();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find a BuildingOccupation (ID : " + id + ")", e);
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<BuildingOccupation> findBuildingOccupationByInsuranceType(InsuranceType insuranceType) {
		List<BuildingOccupation> result = null;
		try {
			result = buildingOccupationRepo.findByInsuranceType(insuranceType);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find a BuildingOccupation by Insurance Type ", e);
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<BuildingOccupation> findByCriteria(String criteria) {
		List<BuildingOccupation> result = null;
		try {
			result = buildingOccupationRepo.findByCriteria(criteria);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find BuildingOccupation by criteria " + criteria, e);
		}
		return result;
	}

}