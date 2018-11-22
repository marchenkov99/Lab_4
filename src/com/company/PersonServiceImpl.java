package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonServiceImpl implements PersonService {
    private Random rand = new Random();

    @Override
    public Director generateDirector() {
        Director director = new Director();
        int curr_name = rand.nextInt(13);
        int curr_surname = rand.nextInt(8);

        director.setName(Name.values()[curr_name]);
        director.setSurname(Surname.values()[curr_surname]);

        return director;
    }
}