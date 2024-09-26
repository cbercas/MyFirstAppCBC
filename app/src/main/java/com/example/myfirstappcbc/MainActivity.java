package com.example.myfirstappcbc;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnSend = findViewById(R.id.btnOk);

        // Vamos asignarle un evento al botón cuando se haga clic
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /* Para navegar a otra Activity necesitamos crear un Intent(contextActivity,
            new Intent(estadoDelActvityActual, ActivityALaQueQueremosNavegar.class)
            */
                Intent intentDetailActivity = new Intent(MainActivity.this, SecondActivity.class);

                // Método para abrir otra activity
                startActivity(intentDetailActivity);
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();

        Log.i("Ciclo de vida", "Ha entrado en el método onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Ciclo de vida", "Ha entrado en el método onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Ha entrado en el método onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "Ha entrado en el método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Ha entrado en el método onDestroy");
    }

}