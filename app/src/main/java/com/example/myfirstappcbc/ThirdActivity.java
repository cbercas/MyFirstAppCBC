package com.example.myfirstappcbc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Buscar los TextViews para mostrar la información
        TextView tvSwitchState = findViewById(R.id.tvSwitchState);
        TextView tvText = findViewById(R.id.tvText);
        TextView tvNumber = findViewById(R.id.tvNumber);
        TextView tvDecimal = findViewById(R.id.tvDecimal);

        // Obtener los datos pasados desde SecondActivity
        boolean switchState = getIntent().getBooleanExtra("switchState", false);
        String text = getIntent().getStringExtra("text");
        int number = getIntent().getIntExtra("number", 0);
        float decimal = getIntent().getFloatExtra("decimal", 0.0f);

        // Mostrar el estado del switch
        if (switchState) {
            tvSwitchState.setText("Check is ON");
        } else {
            tvSwitchState.setText("Check is OFF");
        }

        // Mostrar los datos recibidos
        tvText.setText("Text: " + text);
        tvNumber.setText("Number: " + number);
        tvDecimal.setText("Decimal: " + decimal);


        // Configuración del botón para volver al inicio (MainActivity)
        Button btnBackToMain = findViewById(R.id.btnBackToMain);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear Intent para volver a MainActivity
                Intent intentMain = new Intent(ThirdActivity.this, MainActivity.class);
                intentMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Elimina las actividades anteriores de la pila
                startActivity(intentMain);
                finish(); // Cierra la actividad actual
            }
        });

    }

}