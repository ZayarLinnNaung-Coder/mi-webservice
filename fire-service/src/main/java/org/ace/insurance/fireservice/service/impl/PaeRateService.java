package org.ace.insurance.fireservice.service.impl;

import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.repository.PaeRateRepo;
import org.ace.insurance.fireservice.service.IPaeRateService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaeRateService implements IPaeRateService {
	private final PaeRateRepo paeRateRepo;

	@Transactional(propagation = Propagation.REQUIRED)
	public double findPAERateByClassAndAge(String buildingClassId, int buildingAge) {
		double result = 0.0;
		try {
			result = paeRateRepo.findRateByClassAndAge(buildingClassId, buildingAge);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find PAE Amount by BuildingClassID and BuildingAge" + null, e);
		}
		return result;
	}

}
