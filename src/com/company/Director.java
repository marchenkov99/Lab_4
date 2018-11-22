package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Director extends Person {
    private Random rand = new Random();
    Conductor conductor = new Conductor();
    private List<Musician> musicians = new ArrayList<>();
    private List<Musician> hiredMusicians = new ArrayList<>();

    public List<Musician> getHiredMusicians() {
        return hiredMusicians;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public static final int MUSICIANS_COUNT = 10;

    public void hireMusicians() {
        showMusicians(musicians);
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter how much do you want to hire musicians/> ");
        int ans = Integer.parseInt(reader.nextLine());
        for(int i = 0; i < ans; i++) {
            System.out.print("Enter musician number/> ");
            int num = Integer.parseInt(reader.nextLine());
            musicians.get(num - 1).setHired(true);
            hiredMusicians.add(musicians.get(num - 1));
        }
    }

    public void showMusicians(List<Musician> musicians) {
        if (musicians != null && musicians.size() > 0) {
            System.out.println("+---------------+------------+-------+-------------+------------+-------+-------+");
            System.out.printf("| %-13s | %-11s| %-6s| %-12s| %-11s| %-6s| %-6s|\n", "Surname", "Name", "Age", "Experience", "Instrument", "Income", "Hired");
            for (Musician student : musicians) {
                System.out.println("+---------------+------------+-------+-------------+------------+-------+-------+");
                student.writeInfo();
            }
            System.out.println("+---------------+------------+-------+-------------+------------+-------+-------+");
        } else {
            System.out.println("Data missing\n");
        }
    }

    public List<Musician> setMusicians() {
        for(int i = 0; i < MUSICIANS_COUNT; i++) {
            Musician musician = generateMusician();
            musicians.add(musician);
        }
        return musicians;
    }

    private Musician generateMusician() {
        Musician musician = new Musician();
        int curr_name = rand.nextInt(13);
        int curr_surname = rand.nextInt(8);

        musician.setName(Name.values()[curr_name]);
        musician.setSurname(Surname.values()[curr_surname]);

        return musician;
    }

    public List<Musician> organizeConcert() {
        int curr_city = rand.nextInt(7);
        City concertCity = City.values()[curr_city];
        System.out.println("CONCERT IN " + concertCity);
        List<Musician> performingMusicians = conductor.organizeWork(hiredMusicians);
        System.out.println(conductor.getGroups());
        return performingMusicians;
    }

    public int setSalary() {
        return rand.nextInt(1500) + 500;
    }
}
