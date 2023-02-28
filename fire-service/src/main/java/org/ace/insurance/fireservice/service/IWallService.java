
package org.ace.insurance.fireservice.service;


import org.ace.insurance.fireservice.model.Wall;

import java.util.List;

public interface IWallService {

	 Wall findWallById(String id);

	 List<Wall> findAllWall();

	 List<Wall> findByCriteria(String criteria);
}
