package org.saic.interview.repositories;

import org.saic.interview.domain.DepartmentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentIRepository  extends JpaRepository<DepartmentDomain, Long> {
    DepartmentDomain findByName(String name);
}
