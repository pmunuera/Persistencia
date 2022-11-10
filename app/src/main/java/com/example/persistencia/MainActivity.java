package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView);
        tv.setText(llegirArxiu());
        TextView inputText = findViewById(R.id.textInputEditText);
        inputText.setText(llegirArxiu());
        try{
            OutputStream os = openFileOutput("dades.txt",MODE_PRIVATE);
            String message = "hola q tal\n ";
            os.write(message.getBytes());//L'aplicació escriu aquesta linea cada vegada que comença,
            // per lo que de si no guardem el text, la seguent vegada ens mostrará "hola q tal"
            os.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarArxiu();
            }
        }
        );

    }
    public void guardarArxiu(){
        try{
            OutputStream os = openFileOutput("dades.txt",MODE_PRIVATE);
            TextView text = findViewById(R.id.textInputEditText);
            String secondMessage=String.valueOf(text.getText());
            os.write(secondMessage.getBytes());//Al guardar l'arxiu sobreescribim tot,
            // per lo que quedi a l'input será lo de l'arxiu, sense contar la linea d'inici
            os.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public String llegirArxiu(){
        String text="";
        try {
            FileInputStream file=openFileInput("dades.txt");
            InputStreamReader isr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(isr);
            text = text + br.readLine();
            file.close();
            isr.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}