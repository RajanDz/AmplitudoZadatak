//package com.projekatZaAmplitudo.demoAppForAmplitudo;
//
//import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Departman;
//import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Employee;
//import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Role;
//import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.DepartmanRepository;
//import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.EmployeeRepository;
//import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.RolesRepository;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest(classes = DemoAppForAmplitudoApplication.class)
//public class EmployeesRepositoryTest {
//
//    private Logger logger = LoggerFactory.getLogger(EmployeesRepositoryTest.class);
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    DepartmanRepository departmanRepository;
//
//    @Autowired
//    RolesRepository rolesRepository;
//
//    @Test
//    void addRole(){
//        Role role = new Role();
//        role.setIme("HR");
//        role.setOpis("HR rol obuhvata upravljanje ljudskim resursima u organizaciji, ukljucujuci zaposljavanje, obuku i podrsku zaposlenima.");
//
//        rolesRepository.save(role);
//    }
////    @Test
////    void findAllEmployeersById(){
////        Page<Employee> list = employeeRepository.findByDepartmanId(2,Pageable pageable);
////
////        logger.info("List: {}", list);
////    }
//    @Test
//    void addEmployeers(){
//        Employee employee = new Employee();
//        employee.setJmbg("4925143535367");
//        employee.setIme("Nikola");
//        employee.setPrezime("Petrovic");
//        employee.setGodinaRodjenja(1982);
//        employee.setPlata(1000);
//
//        employeeRepository.save(employee);
//
//        logger.info("Added emplyoeer: {}",employee);
//    }
//@Test
//void updateSalary(){
//        Departman findDepartman = departmanRepository.findById(2).orElseThrow();
//        findDepartman.setProsjecnaPlata(0.0);
//        findDepartman.setBrojRadnika(0);
//        departmanRepository.save(findDepartman);
//
//
//}
//
//    @Test
//    void addDepartman() {
//        Optional<Departman> optionalDepartman = departmanRepository.findById(2);
//        Optional<Employee> optionalEmployee = employeeRepository.findById(25);
//
//        if (optionalDepartman.isPresent() && optionalEmployee.isPresent()) {
//            Departman departman = optionalDepartman.get();
//            Employee employee = optionalEmployee.get();
//
//            Integer brojRadnika = departman.getBrojRadnika();
//            brojRadnika++;
//            departman.setBrojRadnika(brojRadnika);
//
//            double prosjecnaPlata = (departman.getProsjecnaPlata() + employee.getPlata()) / 2;
//            departman.setProsjecnaPlata(prosjecnaPlata);
//
//            employee.setDepartman(departman);
//
//
//            departmanRepository.save(departman);
//            employeeRepository.save(employee);
//        } else {
//
//            System.out.println("Departman ili zaposleni nisu pronadjeni");
//        }
//    }
//
//    @Test
//    void deleteUser(){
//        Employee employee = employeeRepository.findById(5).orElseThrow();
//        employeeRepository.delete(employee);
//    }
//
//    @Test
//    void updateDepartman(){
//        List<Employee> employeeList = employeeRepository.findByDepartmanId(2);
//        Departman departman = null;
//
//        double total = 0;
//
//        for (Employee employee: employeeList){
//            total += employee.getPlata();
//            departman = employee.getDepartman();
//            Integer departmanEmployees = employeeList.size();
//            departman.setBrojRadnika(departmanEmployees);
//        }
//        double prosjecnaPlata = total / employeeList.size();
//
//
//        departman.setProsjecnaPlata(prosjecnaPlata);
//
//        departmanRepository.save(departman);
//    }
//}