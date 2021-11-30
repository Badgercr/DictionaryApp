package com.example.dictionaryapp;

public class Words {
    //--------------------------variables-------------------//
    private String word, definition;
    private int frequency;

    //--------------------------constructors-------------------//

    public Words(String word, String definition, int frequency) {
        this.word = word;
        this.definition = definition;
        this.frequency = frequency;
    }

    //--------------------------functions-------------------//
    //--------------------------setters-------------------//

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    //--------------------------getters-------------------//

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public int getFrequency() {
        return frequency;
    }
}
