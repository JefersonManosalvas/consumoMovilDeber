package com.jpml.figurasgeometricas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button  botonListaDatos,botonBibliografia,botonsuma,botonSumatoria,botonRectangulo,botonRomboide,botonRombo;

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
        botonListaDatos=findViewById(R.id.button_DatosLista);
        botonBibliografia=findViewById(R.id.button_bibliografia);
        botonsuma=findViewById(R.id.button_suma);
        botonSumatoria=findViewById(R.id.button_sumatoria);
        botonRectangulo=findViewById(R.id.button_rectangulo);
        botonRomboide=findViewById(R.id.button_romboide);
        botonRombo=findViewById(R.id.button_rombo);

        botonListaDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, datosLista.class);
                startActivity(intent);

            }
        });
        botonBibliografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bibliografia.class);
                startActivity(intent);
            }
        });
        botonsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Suma.class);
                startActivity(intent);
            }
        });
        botonSumatoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sumatoria.class);
                startActivity(intent);
            }
        });
        botonRectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, areaPerimetroRectangulo.class);
                startActivity(intent);
            }
        });
        botonRomboide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, areaPerimetroRomboide.class);
                startActivity(intent);
            }
        });
        botonRombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, areaPerimetroRombo.class);
                startActivity(intent);
            }
        });

    }
}