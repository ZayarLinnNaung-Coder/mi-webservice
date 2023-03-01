package org.ace.insurance.fireservice.service.impl;


import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.Occupation;
import org.ace.insurance.fireservice.repository.OccupationRepo;
import org.ace.insurance.fireservice.service.IOccupationService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OccupationService implements IOccupationService {

	private final OccupationRepo occupationRepo;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Occupation> findAllOccupation() {
		List<Occupation> result = null;
		try {
			result = occupationRepo.findAll();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find all of Branch)", e);
		}
		return result;
	}

}
