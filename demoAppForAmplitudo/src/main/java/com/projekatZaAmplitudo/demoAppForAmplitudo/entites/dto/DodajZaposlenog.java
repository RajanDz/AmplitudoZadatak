package com.projekatZaAmplitudo.demoAppForAmplitudo.entites.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class DodajZaposlenog {
    private String admin_name;
    private String jmbg;
    private String ime;
    private String prezime;
    private Integer godinaRodjenja;
    private double plata;
}
