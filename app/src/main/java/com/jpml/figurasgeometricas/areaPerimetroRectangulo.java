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

public class areaPerimetroRectangulo extends AppCompatActivity {

    Button botonRectangulo,botonCalcularRectangulo;

    EditText baseRectangulo,alturaRectangulo;

    TextView txtResultadoRectangulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_perimetro_rectangulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        botonRectangulo=findViewById(R.id.button_regresarrectangulo);
        botonCalcularRectangulo=findViewById(R.id.button_calcularRectangulo);
        baseRectangulo=findViewById(R.id.edtxt_baseRectangulo);
        alturaRectangulo=findViewById(R.id.edtxt_alturaRectangulo);
        txtResultadoRectangulo=findViewById(R.id.txtRespuestaRectangulo);
        botonRectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(areaPerimetroRectangulo.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        botonCalcularRectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerServicioWebsumaCliente("http://192.168.1.100:3000/rectangulo/"+baseRectangulo.getText().toString()+"/"+alturaRectangulo.getText().toString());
            }
        });
    }

    private void obtenerServicioWebsumaCliente(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtResultadoRectangulo.setText(response);
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