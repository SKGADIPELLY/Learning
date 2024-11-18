package org.saic.interview.services;

import org.saic.interview.domain.DepartmentDomain;
import org.saic.interview.domain.EmployeeDomain;
import org.saic.interview.modal.DepartmentModal;
import org.saic.interview.modal.EmployeeModal;
import org.saic.interview.repositories.DepartmentIRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl {
    @Autowired
    DepartmentIRepository departmentIRepository;

    public List<DepartmentModal> findAll() {
        List<DepartmentModal> modals = new ArrayList<>();
        List<DepartmentDomain> departmentsList= departmentIRepository.findAll();
        for(DepartmentDomain domain : departmentsList){
            DepartmentModal modal = new DepartmentModal();
            BeanUtils.copyProperties(domain,modal);
            modals.add(modal);
        }
        return modals;
    }
    public DepartmentModal findById(Long id) {
        DepartmentModal modal = new DepartmentModal();
        Optional<DepartmentDomain> optionalDomain = departmentIRepository.findById(id);
        BeanUtils.copyProperties(modal,Optional.ofNullable(optionalDomain));
        return modal;
    }
    public DepartmentModal findByName(String name) {
        DepartmentModal modal = new DepartmentModal();
        DepartmentDomain optionalDomain = departmentIRepository.findByName(name);
        BeanUtils.copyProperties(modal,Optional.ofNullable(optionalDomain));
        return modal;
    }
    public void save(DepartmentModal modal){
        DepartmentDomain departmentDomain = new DepartmentDomain();
        BeanUtils.copyProperties(modal,departmentDomain);
        departmentIRepository.save(departmentDomain);
    }
}
