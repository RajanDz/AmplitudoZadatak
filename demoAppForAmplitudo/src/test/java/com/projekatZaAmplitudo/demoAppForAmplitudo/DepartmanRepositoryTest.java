//package com.projekatZaAmplitudo.demoAppForAmplitudo;
//
//import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Departman;
//import com.projekatZaAmplitudo.demoAppForAmplitudo.repository.DepartmanRepository;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest(classes = DemoAppForAmplitudoApplication.class)
//public class DepartmanRepositoryTest {
//
//    private Logger logger = LoggerFactory.getLogger(DepartmanRepositoryTest.class);
//
//    @Autowired
//    private DepartmanRepository departmanRepository;
//
//
////    @Test
////    void allEmployerAtOneDepartman(){
////        List<Departman> listOfAllEmployeer = departmanRepository.find();
////
////        logger.info("List of all: {}", listOfAllEmployeer);
////    }
//
//    @Test
//    void addDepartman(){
//        Departman departman = new Departman();
//        departman.setNaziv("Finansije");
//        departman.setOpis("tim za finansije");
//
//        departmanRepository.save(departman);
//    }
//
//    @Test
//    void deleteDepartman(){
//        Departman departman = departmanRepository.findById(2).orElseThrow();
//        departmanRepository.delete(departman);
//    }
//
//}
