package com.jpml.figurasgeometricas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class areaPerimetroRombo extends AppCompatActivity {

    Button botonRombo,botonCalcularRombo;

    EditText edtxtDiagonalMayor,edtxtDiagonalMenor;

    TextView respuestaRombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_perimetro_rombo2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        botonRombo=findViewById(R.id.button_regresarRombo);
        botonCalcularRombo=findViewById(R.id.button_calcularRombo);
        edtxtDiagonalMayor=findViewById(R.id.edtxt_diagonalMayor);
        edtxtDiagonalMenor=findViewById(R.id.edtxt_diagonalMenor);
        respuestaRombo=findViewById(R.id.txtRespuestaRombo);
        botonRombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(areaPerimetroRombo.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        botonCalcularRombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerServicioWebsumaCliente("http://192.168.1.100:3000/rombo/"+edtxtDiagonalMayor.getText().toString()+"/"+edtxtDiagonalMenor.getText().toString());
            }
        });
    }

    private void obtenerServicioWebsumaCliente(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                respuestaRombo.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return new HashMap<>();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}