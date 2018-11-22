package com.company;

import java.util.Random;

public class Musician extends Person {
    private int age;
    private int experience;
    private Instrument instrument;
    private int income;
    private boolean hired;

    Random rand = new Random();

    public Musician() {
        age = rand.nextInt(40) + 18;
        experience = rand.nextInt(30);
        int curr_instrument = rand.nextInt(6);
        instrument = Instrument.values()[curr_instrument];
        hired = false;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void play(Director director) {
        int earn = director.setSalary();
        setIncome(earn);
        System.out.printf("%-20s | Param pam pam > earned %-4s $\n", this.toString(), earn);
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void writeInfo() {
        System.out.printf("| %-13s | %-11s| %-6s| %-12s| %-11s| %-6s| %-6s|\n", super.getSurname(), super.getName(), getAge(), getExperience(), getInstrument(), getIncome(), isHired());
    }

    @Override
    public String toString() {
        return super.getSurname().toString() + " " + super.getName().toString();
    }
}

