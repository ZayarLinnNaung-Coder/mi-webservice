package org.ace.insurance.fireservice.service;


import org.ace.insurance.fireservice.model.BuildingOccupation;
import org.ace.insurance.utilityservice.enumeration.InsuranceType;

import java.util.List;


public interface IBuildingOccupationService {

	 BuildingOccupation findBuildingOccupationById(String id);

	 List<BuildingOccupation> findBuildingOccupationByInsuranceType(InsuranceType insuranceType);

	 List<BuildingOccupation> findAllBuildingOccupation();

	 List<BuildingOccupation> findByCriteria(String criteria);
}
