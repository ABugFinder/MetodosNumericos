package com.example.metodosnumericos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button calcularBtn;
    private CheckBox cuadratica;
    private TextView textPotencia;
    private RadioButton bisRB, falsaPosRB, newtonRB, secanteRB, puntoFijoRB;
    private boolean isFuncionCuadrada = false;
    EditText rangA, rangB, primeraX, segundaX, terceraX, aproxA, aproxB;
    TextView caso;
    private String valorDeCaso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bisRB = findViewById(R.id.radioButton_Biseccion);
        falsaPosRB = findViewById(R.id.radioButton_FalsaPos);
        newtonRB = findViewById(R.id.radioButton_Newton);
        secanteRB = findViewById(R.id.radioButton_Secante);
        puntoFijoRB = findViewById(R.id.radioButton_PuntoFijo);

        primeraX = findViewById(R.id.editTextNumPot);
        segundaX = findViewById(R.id.editTextNumValX);
        terceraX = findViewById(R.id.editTextNumValSolo);
        rangA = findViewById(R.id.editTextRangoA);
        rangB = findViewById(R.id.editTextRangoB);

        aproxA = findViewById(R.id.editTextAproxA);
        aproxB = findViewById(R.id.editTextAproxB);

        caso = findViewById(R.id.caso);

        textPotencia = findViewById(R.id.textViewNumElevaX);
        cuadratica = findViewById(R.id.checkboxCuadratica);


        calcularBtn = findViewById(R.id.button_Calcular);
        calcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
                //Problema solucionado. Tienes que darle findview a todos los
                // componentes, incluido los radio buttons. Asegúrate de corregir eso

                if (!isFuncionCuadrada && bisRB.isChecked()) {
                    // Este es el caso 1, donde entra biseccion en funcion cubica,
                    // crea un bundle que guarde este dato, para que la otra activity
                    // seleccione en un swich el caso de esta operacion

                    valorDeCaso = "1";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String mensajePorEnviarA = rangA.getText().toString();
                    intent.putExtra("keyA", mensajePorEnviarA);

                    String mensajePorEnviarB = rangB.getText().toString();
                    intent.putExtra("keyB", mensajePorEnviarB);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Biseccion seleccionado", Toast.LENGTH_SHORT).show();
                } else
                if(isFuncionCuadrada && bisRB.isChecked()){
                    valorDeCaso = "2";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String mensajePorEnviarA = rangA.getText().toString();
                    intent.putExtra("keyA", mensajePorEnviarA);

                    String mensajePorEnviarB = rangB.getText().toString();
                    intent.putExtra("keyB", mensajePorEnviarB);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Biseccion seleccionado", Toast.LENGTH_SHORT).show();
                } else
                if(!isFuncionCuadrada && falsaPosRB.isChecked()){
                    valorDeCaso = "3";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String mensajePorEnviarA = rangA.getText().toString();
                    intent.putExtra("keyA", mensajePorEnviarA);

                    String mensajePorEnviarB = rangB.getText().toString();
                    intent.putExtra("keyB", mensajePorEnviarB);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Falsa Posicion seleccionado", Toast.LENGTH_SHORT).show();
                } else
                if(isFuncionCuadrada && falsaPosRB.isChecked()){
                    valorDeCaso = "4";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String mensajePorEnviarA = rangA.getText().toString();
                    intent.putExtra("keyA", mensajePorEnviarA);

                    String mensajePorEnviarB = rangB.getText().toString();
                    intent.putExtra("keyB", mensajePorEnviarB);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Falsa Posicion seleccionado", Toast.LENGTH_SHORT).show();
                } else
                if(!isFuncionCuadrada && newtonRB.isChecked()){

                    valorDeCaso = "5";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String valorAproxA = aproxA.getText().toString();
                    intent.putExtra("keyAproxA", valorAproxA);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Newton seleccionado", Toast.LENGTH_SHORT).show();
                } else
                if(isFuncionCuadrada && newtonRB.isChecked()){

                    valorDeCaso = "6";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String valorAproxA = aproxA.getText().toString();
                    intent.putExtra("keyAproxA", valorAproxA);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Newton seleccionado", Toast.LENGTH_SHORT).show();
                } else
                if(!isFuncionCuadrada && secanteRB.isChecked()){

                    valorDeCaso = "7";
                    caso.setText(valorDeCaso);
                    String valorCasoEnviar = caso.getText().toString();
                    intent.putExtra("keyCaso", valorCasoEnviar);

                    String valorAproxA = aproxA.getText().toString();
                    intent.putExtra("keyAproxA", valorAproxA);

                    String valorAproxB = aproxB.getText().toString();
                    intent.putExtra("keyAproxB", valorAproxA);

                    String mensajePorEnviarX1 = primeraX.getText().toString();
                    intent.putExtra("keyX1", mensajePorEnviarX1);

                    String mensajePorEnviarX2 = segundaX.getText().toString();
                    intent.putExtra("keyX2", mensajePorEnviarX2);

                    String mensajePorEnviarX3 = terceraX.getText().toString();
                    intent.putExtra("keyX3", mensajePorEnviarX3);

                    //

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Secante seleccionado", Toast.LENGTH_SHORT).show();
                }


            }


        });

        cuadratica.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (cuadratica.isChecked()) {
                    Toast.makeText(MainActivity.this, "Activo", Toast.LENGTH_SHORT).show();
                    textPotencia.setText("3");
                    isFuncionCuadrada = false;
                } else {
                    Toast.makeText(MainActivity.this, "Desactivado", Toast.LENGTH_SHORT).show();
                    textPotencia.setText("2");
                    isFuncionCuadrada = true;
                }
            }
        });

    }
}
