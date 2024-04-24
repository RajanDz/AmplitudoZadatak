package com.projekatZaAmplitudo.demoAppForAmplitudo.repository;

import com.projekatZaAmplitudo.demoAppForAmplitudo.entites.Departman;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmanRepository extends JpaRepository<Departman,Integer> {
}
