package org.ace.insurance.fireservice.service;


import org.ace.insurance.fireservice.model.BuildingClass;

import java.util.List;

public interface IBuildingClassService {
	 BuildingClass findBuildingClassById(String id);

	 List<BuildingClass> findAllBuildingClass();

	 BuildingClass findBuildingClassByRoofWallFloor(String roof, String wall, String floor);

}
