package org.ace.insurance.fireservice.service.impl;

import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.Roof;
import org.ace.insurance.fireservice.repository.RoofRepo;
import org.ace.insurance.fireservice.service.IRoofService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoofService implements IRoofService {

	private final RoofRepo roofRepo;

	public List<Roof> findAllRoof() {
		List<Roof> result = null;
		try {
			List<Roof> roofResult = roofRepo.findAll();
			result = getFixedRoofList(roofResult);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Faield to find all of Roof)", e);
		}
		return result;
	}

	public Roof findRoofById(String id) {
		Roof result = null;
		try {
			result = roofRepo.findById(id).get();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Faield to find a Roof (ID : " + id + ")", e);
		}
		return result;
	}
	
	private List<Roof> getFixedRoofList(List<Roof> result){
		List<Roof> wallList = new ArrayList<>();
		String[] wallString = new String[] {"ISSYS0260001000000000231032013","ISSYS0260001000000000731032013","ISSYS0260001000000000531032013",
											"ISSYS0260001000000000931032013","ISSYS0260001000000000331032013","ISSYS026001000000001020022014",
											"ISSYS0260001000000000831032013","ISSYS0260001000000000631032013","ISSYS0260001000000000431032013",
											"ISSYS0260001000000000131032013"
		};
		for(Roof wall : result) {
			for(String wallId : wallString) {
				if(wall.getId()==wallId || wall.getId().trim().equals(wallId)) {
					wallList.add(wall);
				}
			}
		}
		return wallList;
	}
}