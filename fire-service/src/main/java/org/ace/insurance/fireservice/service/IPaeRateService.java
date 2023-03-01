package org.ace.insurance.fireservice.service;

public interface IPaeRateService {

	double findPAERateByClassAndAge(String buildingClassId, int buildingAge);
}
