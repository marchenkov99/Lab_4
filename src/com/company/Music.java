package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Music {
    private String name;
    private List<Instrument> instruments;

    public Music(String name, List<Instrument> instruments) {
        this.name = name;
        this.instruments = instruments;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public String get(int i) {
        return name;
    }
}
