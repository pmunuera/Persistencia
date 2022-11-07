package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            OutputStream os = openFileOutput("dades.txt",MODE_PRIVATE);
            String message = "hola q tal\n ";
            os.write(message.getBytes());
            os.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    OutputStream os = openFileOutput("dades.txt",MODE_PRIVATE);
                    String message = "hola q tal";
                    TextView text = findViewById(R.id.textInputEditText);
                    String secondMessage=String.valueOf(text.getText());
                    os.write(message.getBytes());
                    os.write(secondMessage.getBytes());
                    os.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        );
    }
}