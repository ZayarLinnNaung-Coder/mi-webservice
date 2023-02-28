
package org.ace.insurance.fireservice.repository;


import org.ace.insurance.fireservice.model.Wall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WallRepo extends JpaRepository<Wall, String> {

    @Query(value = "Select w from Wall w where w.name LIKE CONCAT('%',:criteria,'%')")
    List<Wall> findByCriteria(@Param("criteria") String criteria);
}
