package org.ace.insurance.fireservice.repository;


import org.ace.insurance.fireservice.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepo extends JpaRepository<Occupation, String> {
}
