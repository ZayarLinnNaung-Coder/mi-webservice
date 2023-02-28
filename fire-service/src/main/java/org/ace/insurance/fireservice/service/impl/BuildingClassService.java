package org.ace.insurance.fireservice.service.impl;

import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.BuildingClass;
import org.ace.insurance.fireservice.repository.BuildingClassRepo;
import org.ace.insurance.fireservice.service.IBuildingClassService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingClassService implements IBuildingClassService {

	private final BuildingClassRepo buildingClassRepo;

	public List<BuildingClass> findAllBuildingClass() {
		try {
			return buildingClassRepo.findAll();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find all of BuildingClass)", e);
		}
	}

	public BuildingClass findBuildingClassById(String id) {
		 BuildingClass result = null;
		 try {
		 	result = buildingClassRepo.findById(id).get();
		 } catch (DAOException e) {
			 throw new SystemException(e.getErrorCode(), "Failed to find a BuildingClass by Roof,Wall,Floor ", e);
		 }
		return result;
	}


	public BuildingClass findBuildingClassByRoofWallFloor(String roof, String wall, String floor) {
		BuildingClass result = null;
		try {
			result = buildingClassRepo.findByRoofWallFloor(roof, wall, floor);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find a BuildingClass by Roof,Wall,Floor ", e);
		}
		return result;
	}
}