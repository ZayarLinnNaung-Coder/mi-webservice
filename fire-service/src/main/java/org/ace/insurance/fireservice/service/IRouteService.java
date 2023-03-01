package org.ace.insurance.fireservice.service;




import org.ace.insurance.fireservice.model.Route;

import java.util.List;

public interface IRouteService {

	 List<Route> findAllRoute();

	 Route findRouteById(String id);

	 List<Route> findByCriteria(String criteria);
	
	 List<Route> findRouteByInsuranceType(String insuranceType);
}
