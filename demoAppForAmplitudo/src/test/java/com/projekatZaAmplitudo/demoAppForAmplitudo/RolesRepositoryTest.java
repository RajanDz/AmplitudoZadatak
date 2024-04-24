package com.projekatZaAmplitudo.demoAppForAmplitudo;

import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Employee;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Role;
import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest(classes = DemoAppForAmplitudoApplication.class)
public class RolesRepositoryTest {

    private static Logger logger = LoggerFactory.getLogger(RolesRepositoryTest.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void addRole(){
        Employee employee = employeeRepository.findById(20).orElseThrow();
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1);
        roles.add(role);
        employee.setRoles(roles);

        employeeRepository.save(employee);
    }

}
