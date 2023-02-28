
package org.ace.insurance.fireservice.service;


import org.ace.insurance.fireservice.model.Floor;

import java.util.List;

public interface IFloorService {

	 Floor findFloorById(String id);

	 List<Floor> findAllFloor();
}
