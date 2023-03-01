package org.ace.insurance.fireservice.repository;


import org.ace.insurance.fireservice.model.PAEBuildingClass;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaeRateRepo extends JpaRepository<PAEBuildingClass, String> {

    @Query(value = "SELECT p.paeRate FROM PAEBuildingClass p WHERE p.buildingClass.id = :buildingClassId AND p.fromAge <= :buildingAge AND p.toAge >= :buildingAge")
    double findRateByClassAndAge(@Param("buildingClassId") String buildingClassId,@Param("buildingAge") int buildingAge) throws DAOException;

}
