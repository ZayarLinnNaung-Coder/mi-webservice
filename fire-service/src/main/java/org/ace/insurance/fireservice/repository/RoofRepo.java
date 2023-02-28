package org.ace.insurance.fireservice.repository;


import org.ace.insurance.fireservice.model.Roof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoofRepo extends JpaRepository<Roof, String> {
}
