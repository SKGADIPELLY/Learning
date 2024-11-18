package org.saic.interview.repositories;

import org.saic.interview.domain.EmployeeDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeIRepository  extends JpaRepository<EmployeeDomain, Long> {
    EmployeeDomain findByEmail(String email);

}
