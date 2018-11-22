package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nMARCHENKOV IVAN IC-62");
        System.out.println("|===================================ORCHESTRA===================================|");
        PersonService personService = new PersonServiceImpl();
        Director director = personService.generateDirector();

        director.setMusicians();
        director.hireMusicians();
        director.showMusicians(director.getHiredMusicians());
        List<Musician> performingMusicians = director.organizeConcert();
        for (Musician perfMusician: performingMusicians) {
            perfMusician.play(director);
        }
        director.showMusicians(director.getHiredMusicians());
    }
}
