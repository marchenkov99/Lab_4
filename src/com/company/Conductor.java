package com.company;

import java.util.*;

public class Conductor extends Person {
    private Random rand = new Random();
    List<String> compositions = new ArrayList<String>();
    private Music composition;
    private Map<Instrument, List<Musician>> groups;

    public Conductor() {
        int curr_name = rand.nextInt(13);
        int curr_surname = rand.nextInt(8);

        setName(Name.values()[curr_name]);
        setSurname(Surname.values()[curr_surname]);
    }

    public Map<Instrument, List<Musician>> getGroups() {
        return groups;
    }

    public void setGroups(Map<Instrument, List<Musician>> groups) {
        this.groups = groups;
    }

    List<Musician> organizeWork(List<Musician> musicians) {
        Music composition = setComposition();
        System.out.printf("Composition: " + composition.get(0) + "\n");
        List<Instrument> compositionInstruments = composition.getInstruments();
        List<Musician> performingMusicians = new ArrayList<>();
        Map<Instrument, List<Musician>> musicGroups = new HashMap<>();

        Musician musician;
        for (int i = 0; i < musicians.size(); i++) {
            musician = musicians.get(i);

            if (compositionInstruments.contains(musician.getInstrument())) {
                if (musicGroups.get(musician.getInstrument()) != null) {
                    musicGroups.get(musician.getInstrument()).add(musician);
                }
                else {
                    musicGroups.put(
                        musician.getInstrument(),
                        new ArrayList<Musician>(
                            Arrays.asList(musician)
                        )
                    );
                }
                performingMusicians.add(musician);
            }
        }

        this.groups = musicGroups;
        return performingMusicians;
    }

    public Music setComposition() {
        List<Music> compositions = new ArrayList<>();

        compositions.add(
                new Music("Swan Lake",
                new ArrayList<Instrument>(
                    Arrays.asList(
                        Instrument.GUITAR,
                        Instrument.VIOLIN
                    )
                )
            )
        );

        compositions.add(
            new Music("Little night serenade",
                new ArrayList<Instrument>(
                    Arrays.asList(
                        Instrument.TRUMPET,
                        Instrument.TROMBONE
                    )
                )
            )
        );

        compositions.add(
            new Music("Mars",
                new ArrayList<Instrument>(
                    Arrays.asList(
                        Instrument.DRUMS,
                        Instrument.PIANO
                    )
                )
            )
        );

        compositions.add(
            new Music("Flight of the Valkyries",
                new ArrayList<Instrument>(
                    Arrays.asList(
                        Instrument.DRUMS,
                        Instrument.PIANO
                    )
                )
            )
        );

        Random superRandomizer = new Random();
        return compositions.get(superRandomizer.nextInt(4));
    }
}
