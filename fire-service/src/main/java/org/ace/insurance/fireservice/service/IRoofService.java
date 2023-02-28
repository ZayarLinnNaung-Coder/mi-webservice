package org.ace.insurance.fireservice.service;



import org.ace.insurance.fireservice.model.Roof;

import java.util.List;

public interface IRoofService {

	Roof findRoofById(String id);

	List<Roof> findAllRoof();
}
