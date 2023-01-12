package br.com.beachtennisbrazil.api.app.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class Person {
    private String name;
    @Column(name = "document", unique = true)
    private String cpf;
    private String telephone;


}
