package com.example.dictionaryapp;

import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dictionary {

    //--------------------------variables-------------------//
    ArrayList<Words> list = new ArrayList<Words>(); // hold the list of words dictionary uses
    EditText wordEntry, defEntry, freqEntry, wordFindEntry;
    TextView notifier, freqWord1, freqWord2, freqWord3, definition, removed_notifier;
    //--------------------------constructors-------------------//

    public Dictionary(EditText wordEntry, EditText defEntry, EditText freqEntry, TextView notifier) {
        this.wordEntry = wordEntry;
        this.defEntry = defEntry;
        this.freqEntry = freqEntry;
        this.notifier = notifier;
    }

    public Dictionary() {
    }

    //--------------------------functions-------------------//

    /**
     * Add a word to the list with its frquency and menaing
     */
    public void addWord(){
        try {
            if (freqEntry.getText().toString().equals("")){
                Words obj = new Words(wordEntry.getText().toString(),defEntry.getText().toString(), 1);
                list.add(obj);
                notifier.setText("Added");
            }else{
                Words obj = new Words(wordEntry.getText().toString(),defEntry.getText().toString(), Integer.parseInt(freqEntry.getText().toString()));
                list.add(obj);
                notifier.setText("Added");
            }
        }catch (Exception e){
            notifier.setText("Error, try again");
        }

    }

    /**
     * clear all fields on new word page
     */
    public void clearAdd(){
        wordEntry.setText("");
        defEntry.setText("");
        freqEntry.setText("");
        notifier.setText("Cleared");
    }

    /**
     * finds all word based off of prefixes
     */
    public void findWord(){
        // clear all fields
        freqWord1.setText("");
        freqWord2.setText("");
        freqWord3.setText("");
        definition.setText("");
        removed_notifier.setText("");

        ArrayList<Words> freqWords = new ArrayList<Words>(); // frequent words list to keep track of autofill

        String wordToFind = wordFindEntry.getText().toString();
        if (wordToFind.equals("")){
            return;
        }
        for (int i = 0; i < list.size();i++){
            String word = list.get(i).getWord();
            if (word.toUpperCase().startsWith(wordToFind.toUpperCase())){ // if word in list starts with prefixes then add to list
                freqWords.add(list.get(i));
            }
        }



        Collections.sort(freqWords, new Comparator<Words>() { // sort words by frequency, high to low
            public int compare(Words c1, Words c2) {
                if (c1.getFrequency() > c2.getFrequency()) return -1;
                if (c1.getFrequency() < c2.getFrequency()) return 1;
                return 0;
            }});

        //set text in frequency word sections as well as the definitions for each
        for (int i = 0; i < freqWords.size(); i++){
            if (i == 0){
                freqWord1.setText(freqWords.get(i).getWord());
                definition.setText(freqWords.get(i).getWord() + ": " + freqWords.get(i).getDefinition() + "\n\n");
            }
            else if (i == 1){
                freqWord2.setText(freqWords.get(i).getWord());
                definition.append(freqWords.get(i).getWord() + ": " + freqWords.get(i).getDefinition() + "\n\n");
            }
            else if (i == 2){
                freqWord3.setText(freqWords.get(i).getWord());
                definition.append(freqWords.get(i).getWord() + ": " + freqWords.get(i).getDefinition() + "\n\n");
            }
        }

    }

    /**
     * removes the word inputted in the find text box
     */
    public void remove(){
        ArrayList<Words> freqWords = new ArrayList<Words>();
        // finds word that equal to the textbox int he dictionary list
        String wordToFind = wordFindEntry.getText().toString();
        if (wordToFind.equals("")){
            return;
        }
        for (int i = 0; i < list.size();i++){
            String word = list.get(i).getWord();
            if (word.equalsIgnoreCase(wordToFind)){
                freqWords.add(list.get(i));
            }
        }
        if (freqWords.size() == 0){
            removed_notifier.setText("Word to remove not found");
            return;
        }
        // removes the word from the list and sets the text for the notifier
        for (int i = 0; i < freqWords.size(); i++){
            if (i == 0){
                list.remove(freqWords.get(i));
                removed_notifier.setText(freqWords.get(i).getWord() + " removed");
            }
            else if (i == 1){
                list.remove(freqWords.get(i));
            }
            else if (i == 2){
                list.remove(freqWords.get(i));
            }
        }

    }

    //--------------------------setters-------------------//

    public void setWordEntry(EditText wordEntry) {
        this.wordEntry = wordEntry;
    }

    public void setDefEntry(EditText defEntry) {
        this.defEntry = defEntry;
    }

    public void setFreqEntry(EditText freqEntry) {
        this.freqEntry = freqEntry;
    }

    public void setNotifier(TextView notifier) {
        this.notifier = notifier;
    }

    public void setFreqWord1(TextView freqWord1) {
        this.freqWord1 = freqWord1;
    }

    public void setFreqWord2(TextView freqWord2) {
        this.freqWord2 = freqWord2;
    }

    public void setFreqWord3(TextView freqWord3) {
        this.freqWord3 = freqWord3;
    }

    public void setDefinition(TextView definition) {
        this.definition = definition;
    }

    public void setWordFindEntry(EditText wordFindEntry) {
        this.wordFindEntry = wordFindEntry;
    }

    public void setRemoved_notifier(TextView removed_notifier) {
        this.removed_notifier = removed_notifier;
    }
    //--------------------------getters-------------------//


    public ArrayList<Words> getList() {
        return list;
    }

}
