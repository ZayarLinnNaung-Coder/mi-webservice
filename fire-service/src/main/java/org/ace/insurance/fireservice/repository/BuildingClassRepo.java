package org.ace.insurance.fireservice.repository;


import org.ace.insurance.fireservice.model.BuildingClass;
import org.ace.insurance.utilityservice.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingClassRepo extends JpaRepository<BuildingClass, String> {

    @Query(value = "SELECT b FROM BuildingClass b JOIN b.classValueList cv WHERE cv.roof.id = :roof AND cv.wall.id = :wall AND cv.floor.id = :floor")
    BuildingClass findByRoofWallFloor(@Param("roof") String roof, @Param("wall") String wall, @Param("floor") String floor) throws DAOException;

}
