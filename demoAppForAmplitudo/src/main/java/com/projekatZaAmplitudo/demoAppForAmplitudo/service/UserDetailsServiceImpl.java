
package com.projekatZaAmplitudo.demoAppForAmplitudo.service;

import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Employee;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Role;
import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl  {

    private final EmployeeRepository employeeRepository;

    public UserDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Set<String> getUserRoles(String username) {
        Optional<Employee> employeeOptional = employeeRepository.findByIme(username);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return employee.getRoles().stream()
                    .map(Role::getIme)
                    .collect(Collectors.toSet());
        } else {
            return new HashSet<>();
        }
    }
}

