package com.example.myfirstappcbc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnSend = findViewById(R.id.btnSend);
        Button btnReset = findViewById(R.id.btnReset);
        EditText etText = findViewById(R.id.etText);
        EditText etNum = findViewById(R.id.etNum);
        EditText etDecimal = findViewById(R.id.etDecimal);
        Switch switch1 = findViewById(R.id.switch1);

        // Evento de clic para el botón ENVIAR
        btnSend.setOnClickListener(new View.OnClickListener() {
         @Override
           public void onClick(View v) {

            // Validación de campos vacíos
             if (etText.getText().toString().equals("")){
                 Toast toastName = new Toast(SecondActivity.this);
                 toastName.setText("Name can´t be empty");
                 toastName.show();
             } else if(etNum.getText().toString().equals("")){
                 Toast toastSurname = new Toast(SecondActivity.this);
                 toastSurname.setText("Number can´t be empty");
                 toastSurname.show();
             }else if(etDecimal.getText().toString().equals("")){
                 Toast toastSurname = new Toast(SecondActivity.this);
                 toastSurname.setText("Decimal can´t be empty");
                 toastSurname.show();
             }else {
                     /* Para navegar a otra Activity necesitamos crear un Intent(contextActivity,
            new Intent(estadoDelActvityActual, ActivityALaQueQueremosNavegar.class)
            */
                 Intent intentDetailActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                 // Añado las clave-valor al intent
                 intentDetailActivity.putExtra("text", etText.getText().toString());
                 intentDetailActivity.putExtra("number",Integer.parseInt(etNum.getText().toString()));
                 intentDetailActivity.putExtra("decimal", Float.parseFloat(etDecimal.getText().toString()));
                 // Obtener el estado del switch (true o false)
                 boolean isSwitchChecked = switch1.isChecked();
                 intentDetailActivity.putExtra("switchState", isSwitchChecked); // Pasar el estado del Switch

                 // Método para abrir otra activity
                 startActivity(intentDetailActivity);
             }
            }
        });
        // Evento de clic para el botón VOLVER
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etText.setText("");
                etNum.setText("");
                etDecimal.setText("");

            Intent intentMainActivity = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intentMainActivity);
            finish();

            }
        });

    }
}