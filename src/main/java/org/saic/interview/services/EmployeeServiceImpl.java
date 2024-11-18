package org.saic.interview.services;

import org.saic.interview.domain.DepartmentDomain;
import org.saic.interview.domain.EmployeeDomain;
import org.saic.interview.modal.DepartmentModal;
import org.saic.interview.modal.EmployeeModal;
import org.saic.interview.repositories.EmployeeIRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeIRepository employeeIRepository;

    public List<EmployeeModal> findAll() {
        List<EmployeeModal> modals = new ArrayList<>();
        List<EmployeeDomain> employeeDomains= employeeIRepository.findAll();
        for(EmployeeDomain domain : employeeDomains){
            EmployeeModal modal = new EmployeeModal();
            BeanUtils.copyProperties(domain,modal);
            DepartmentModal deptModal = new DepartmentModal();
            BeanUtils.copyProperties(domain.getDepartment(),deptModal);
            modal.setDepartment(deptModal);
            modals.add(modal);
        }
        return modals;
    }

    public EmployeeModal findById(Long id) {
        EmployeeModal modal = new EmployeeModal();
        Optional<EmployeeDomain> optionalDomain = employeeIRepository.findById(id);
        BeanUtils.copyProperties(optionalDomain.get(),modal);
        DepartmentModal deptModal = new DepartmentModal();
        BeanUtils.copyProperties(optionalDomain.get().getDepartment(),deptModal);
        modal.setDepartment(deptModal);
        return modal;
    }

    public EmployeeModal findByEmail(String email) {
        EmployeeModal modal = new EmployeeModal();
        EmployeeDomain employee = employeeIRepository.findByEmail(email);
        BeanUtils.copyProperties(employee,modal);
        DepartmentModal deptModal = new DepartmentModal();
        BeanUtils.copyProperties(employee.getDepartment(),deptModal);
        modal.setDepartment(deptModal);
        return modal;
    }

    public void save(EmployeeModal modal){
        EmployeeDomain domain = new EmployeeDomain();
        BeanUtils.copyProperties(modal,domain);
        employeeIRepository.save(domain);
    }
}
