package org.ace.insurance.fireservice.repository;

import org.ace.insurance.fireservice.model.BuildingOccupation;
import org.ace.insurance.utilityservice.enumeration.InsuranceType;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingOccupationRepo extends JpaRepository<BuildingOccupation, String> {

     @Query(value = "SELECT b from BuildingOccupation b WHERE b.name LIKE CONCAT('%',:criteria,'%')")
     List<BuildingOccupation> findByCriteria(String criteria) throws DAOException;

     @Query(value = "Select b from BuildingOccupation b where b.name Like CONCAT('%',:insuranceType,'%')",nativeQuery = true)
     List<BuildingOccupation> findByInsuranceType(InsuranceType insuranceType) throws DAOException;


}
