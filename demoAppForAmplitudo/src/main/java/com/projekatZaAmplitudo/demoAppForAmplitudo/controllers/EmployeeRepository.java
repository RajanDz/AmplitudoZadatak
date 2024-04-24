package com.projekatZaAmplitudo.demoAppForAmplitudo.controllers;

import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Departman;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Employee;
import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.dto.DodajZaposlenog;
import com.projekatZaAmplitudo.demoAppForAmplitudo.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRepository {


    private final EmployeeService employeeService;

    public EmployeeRepository(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/listOfEmployees/{departman_id}")
    public ResponseEntity<List<Employee>> listOfEmployeesById(
            @PathVariable Integer departman_id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> employeeList = employeeService.employeeList(departman_id, pageable);
        List<Employee> content = employeeList.getContent();
        return ResponseEntity.ok().body(content);
    }



    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseEntity<String>> addEmployee(@RequestBody DodajZaposlenog dodajZaposlenog){
        ResponseEntity<String> employee = employeeService.addEmployee(dodajZaposlenog);
        return ResponseEntity.ok().body(employee);
    }
    @GetMapping("/deleteEmployeer/{admin_name}/{employee_id}")
    public ResponseEntity<ResponseEntity<String>> deleteEmployeer(
            @PathVariable String admin_name
            ,@PathVariable  Integer employee_id){

        ResponseEntity<String> employee = employeeService.deleteEmployee(admin_name,employee_id);
        return ResponseEntity.ok().body(employee);
    }
    @GetMapping("/listOfAllDepartmans")
        public ResponseEntity<List<Departman>> listOfEmployeesById(
                @RequestParam(defaultValue = "0") Integer pageNo,
                @RequestParam(defaultValue = "5") Integer pageSize){

            Pageable pageable = PageRequest.of(pageNo,pageSize);
           Page<Departman> listOfAll = employeeService.listOfAll(pageable);
           List<Departman> content = listOfAll.getContent();
        return ResponseEntity.ok().body(content);
    }
    @GetMapping("/departmanDetails/{id}")
    public ResponseEntity<Departman>statisticOfDepartman(@PathVariable Integer id){
        Departman departman = employeeService.calculateDepartmanStatistics(id);
        return ResponseEntity.ok().body(departman);
    }
}
