package org.ace.insurance.fireservice.service.impl;


import lombok.AllArgsConstructor;
import org.ace.insurance.fireservice.model.Route;
import org.ace.insurance.fireservice.repository.RouteRepo;
import org.ace.insurance.fireservice.service.IRouteService;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class RouteService implements IRouteService {

	private final RouteRepo routeRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Route> findAllRoute() {
		List<Route> result = null;
		try {
			result = routeRepo.findAll();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find all route", e);
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Route findRouteById(String id) {
		Route route = null;
		try {
			route = routeRepo.findById(id).get();
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find a Company (ID : " + id + ")", e);
		}
		return route;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Route> findByCriteria(String criteria) {
		List<Route> result = null;
		try {
			result = routeRepo.findByCriteria(criteria);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find Route by criteria " + criteria, e);
		}
		return result;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Route> findRouteByInsuranceType(String insuranceType) {
		List<Route> route = null;
		try {
			route = routeRepo.findByInsuranceType(insuranceType);
		} catch (DAOException e) {
			throw new SystemException(e.getErrorCode(), "Failed to find Route (Insurance Type : " + insuranceType + ")", e);
		}
		return route;
	}
}
