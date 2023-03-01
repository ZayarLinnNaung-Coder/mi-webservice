package org.ace.insurance.fireservice.repository;


import org.ace.insurance.fireservice.model.Route;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RouteRepo extends JpaRepository<Route, String> {

    @Query(value = "SELECT r from Route r WHERE r.name LIKE CONCAT('%',:criteria,'%')")
    List<Route> findByCriteria(@Param("criteria") String criteria) throws DAOException;

    @Query(value = "Select r from Route r where r.name Like CONCAT('%',:insuranceType,'%')",nativeQuery = true)
    List<Route> findByInsuranceType(@Param("insuranceType") String insuranceType) throws DAOException;

}
