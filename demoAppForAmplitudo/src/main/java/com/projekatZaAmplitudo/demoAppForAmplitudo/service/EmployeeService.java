package com.projekatZaAmplitudo.demoAppForAmplitudo.service;

import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Departman;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Employee;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Role;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.dto.DodajZaposlenog;
import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.DepartmanRepository;
import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.EmployeeRepository;
import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.RolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    private final UserDetailsServiceImpl userDetailsService;
    private final EmployeeRepository employeeRepository;
    private final RolesRepository rolesRepository;
    private final DepartmanRepository departmanRepository;

    public EmployeeService(UserDetailsServiceImpl userDetailsService, EmployeeRepository employeeRepository, RolesRepository rolesRepository, DepartmanRepository departmanRepository) {
        this.userDetailsService = userDetailsService;
        this.employeeRepository = employeeRepository;
        this.rolesRepository = rolesRepository;
        this.departmanRepository = departmanRepository;
    }

    public Page<Employee> employeeList(Integer departmentId, Pageable pageable) {
        return employeeRepository.findByDepartmanId(departmentId, pageable);
    }
    public Page<Departman> listOfAll(Pageable pageable){
        return departmanRepository.findAll(pageable);
    }
    public Departman calculateDepartmanStatistics(Integer id) {
            return departmanRepository.findById(id).orElseThrow();
    }
    public ResponseEntity<String> addEmployee(DodajZaposlenog dodajZaposlenog) {
        Set<String> adminRoles = userDetailsService.getUserRoles(dodajZaposlenog.getAdmin_name());

        if (adminRoles.contains("Super Admin")) {
            Departman departman = departmanRepository.findById(2)
                    .orElseThrow(() -> new RuntimeException("Ne možete dodati radnika jer departman nije pronađen."));

            Role role = rolesRepository.findById(2)
                    .orElseThrow(() -> new RuntimeException("Ne mozete dodati radnika jer uloga nije pronadjena."));

            Employee employee = new Employee();
            employee.setJmbg(dodajZaposlenog.getJmbg());
            employee.setIme(dodajZaposlenog.getIme());
            employee.setPrezime(dodajZaposlenog.getPrezime());
            employee.setGodinaRodjenja(dodajZaposlenog.getGodinaRodjenja());
            employee.setPlata(dodajZaposlenog.getPlata());

            Set<Role> roles = new HashSet<>();
            roles.add(role);
            employee.setRoles(roles);

            int brojRadnika = departman.getBrojRadnika() + 1;
            double ukupnaPlata = departman.getProsjecnaPlata() * departman.getBrojRadnika() + dodajZaposlenog.getPlata();
            double prosjecnaPlata = ukupnaPlata / brojRadnika;

            departman.setBrojRadnika(brojRadnika);
            departman.setProsjecnaPlata(prosjecnaPlata);
            employee.setDepartman(departman);
            departmanRepository.save(departman);
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Uspjesno ste dodali zaposlenog");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ne mozete dodati zaposlenog jer nemate odredjena prava (Super Admin)");        }
    }



    public ResponseEntity<String> deleteEmployee(String admin_name, Integer employee_id) {
        Set<String> adminRoles = userDetailsService.getUserRoles(admin_name);

        if (adminRoles.contains("Admin")) {
            Optional<Employee> findEmployee = employeeRepository.findById(employee_id);

            if (findEmployee.isPresent()) {
                Employee employee = findEmployee.get();
                Departman departman = employee.getDepartman();
                Integer brojRadnika = departman.getBrojRadnika();
                double total = departman.getProsjecnaPlata() * brojRadnika;
                total -= employee.getPlata();
                brojRadnika--;
                double prosjecnaPlata = brojRadnika > 0 ? total / brojRadnika : 0;
                departman.setProsjecnaPlata(prosjecnaPlata);
                departman.setBrojRadnika(brojRadnika);
                departmanRepository.save(departman);
                employeeRepository.delete(employee);

                return ResponseEntity.ok().body("Uspjesno ste izbrisali zaposlenog.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Zaposleni sa id: " + employee_id + " nije pronadjen.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Zaposleni ne moze biti izbrisan jer nemate prava admina.");
        }
    }



}
