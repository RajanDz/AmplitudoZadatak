package com.projekatZaAmplitudo.demoAppForAmplitudo.repository;

import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByDepartmanId(Integer departmentId, Pageable pageable);


    int countByDepartmanId(Integer id);


    Optional<Employee> findByIme(String ime);
}
