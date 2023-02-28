package org.ace.insurance.fireservice.service.impl;

import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.Floor;
import org.ace.insurance.fireservice.repository.FloorRepo;
import org.ace.insurance.fireservice.service.IFloorService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FloorService implements IFloorService {

	private final FloorRepo floorRepo;

	public List<Floor> findAllFloor() {
		List<Floor> result = null;
			try {
				//result = floorRepo.findAll();
				result = getFixedFloorList();
			} catch (DAOException e) {
				throw new SystemException(e.getErrorCode(), "Failed to find all of Floor)", e);
			}
		return result;
	}

	public Floor findFloorById(String id) {
		Floor result = null;
		try {
			result = floorRepo.findById(id).get();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find a Floor (ID : " + id + ")", e);
		}
		return result;
	}
	
	private List<Floor> getFixedFloorList(){
		List<Floor> floorList = new ArrayList<>();
		Floor floor = new Floor("ISSYS0280001000000000131032013","CONCRETE");
		floorList.add(floor);
		floor = new Floor("ISSYS0280001000000000231032013","GROUND");
		floorList.add(floor);
		floor = new Floor("ISSYS0280001000000000331032013","TIMBER");
		floorList.add(floor);
		return floorList;
	}
}