package org.ace.insurance.fireservice.service.impl;

import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.Wall;
import org.ace.insurance.fireservice.repository.WallRepo;
import org.ace.insurance.fireservice.service.IWallService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WallService implements IWallService {


	private final WallRepo wallRepo;

	public List<Wall> findAllWall() {
		
		List<Wall> result = null;
		try {
			List<Wall> wallResult = wallRepo.findAll();
			result = getFixedWallList(wallResult);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find all of Wall)", e);
		}
		return result;
	}

	public Wall findWallById(String id) {
		Wall result = null;
		try {
			result = wallRepo.findById(id).get();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find a Wall (ID : " + id + ")", e);
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Wall> findByCriteria(String criteria) {
		List<Wall> result = null;
		try {
			result = wallRepo.findByCriteria(criteria);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find Wall by criteria " + criteria, e);
		}
		return result;
	}
	private List<Wall> getFixedWallList(List<Wall> result){
		List<Wall> wallList = new ArrayList<>();
		String[] wallString = new String[] {"ISSYS0270001000000000931032013","ISSYS0270001000000001231032013","ISSYS0270001000000000331032013",
											"ISSYS0270001000000000531032013","ISSYS0270001000000000231032013","ISSYS0270001000000001031032013",
											"ISSYS0270001000000000431032013","ISSYS0270001000000000831032013","ISSYS0270001000000001331032013",
											"ISSYS0270001000000000731032013","ISSYS0270001000000000631032013","ISSYS0270001000000000131032013",
											"ISSYS0270001000000001131032013","ISSYS027001000000001404032014"
		};
		for(Wall wall : result) {
			for(String wallId : wallString) {
				if(wall.getId()==wallId || wall.getId().trim().equals(wallId)) {
					wallList.add(wall);
				}
			}
		}
		return wallList;
	}
}