package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;

public class newWord extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        // setting all workspaces for new word page
        MainActivity.dict.setWordEntry(findViewById(R.id.enter_word_add));
        MainActivity.dict.setDefEntry(findViewById(R.id.enter_meaning));
        MainActivity.dict.setFreqEntry(findViewById(R.id.enter_freq_add));
        MainActivity.dict.setNotifier(findViewById(R.id.add_notifier));

        // setting all click listeners
        findViewById(R.id.home_page_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(newWord.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MainActivity.dict.addWord();
            }
        });
        findViewById(R.id.clear_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MainActivity.dict.clearAdd();
            }
        });

    }
}