package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // instant for dictionary object to be use by all classes
    public static Dictionary dict = new Dictionary();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting the workspaces and editTexts
        MainActivity.dict.setWordFindEntry(findViewById(R.id.enter_word_find));
        MainActivity.dict.setFreqWord1(findViewById(R.id.freq_word1));
        MainActivity.dict.setFreqWord2(findViewById(R.id.freq_word2));
        MainActivity.dict.setFreqWord3(findViewById(R.id.freq_word3));
        MainActivity.dict.setDefinition(findViewById(R.id.word_definition));
        MainActivity.dict.setRemoved_notifier(findViewById(R.id.remove_notify));
        // setting click listeners for home page buttons
        findViewById(R.id.new_word_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, newWord.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.find_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MainActivity.dict.findWord();
            }
        });
        findViewById(R.id.remove_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MainActivity.dict.remove();
            }
        });
    }
}