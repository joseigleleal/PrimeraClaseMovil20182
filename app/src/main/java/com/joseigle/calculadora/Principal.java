package com.joseigle.calculadora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private EditText n1, n2;
    private TextView res;
    private Resources recursos;
    private Spinner operaciones;
    private String op[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        n1= findViewById(R.id.txtPN);
        n2= findViewById(R.id.txtSN);
        res= findViewById(R.id.txtR);
        operaciones = findViewById(R.id.cmbOp);
        recursos= this.getResources();
        op = recursos.getStringArray(R.array.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op);

        operaciones.setAdapter(adapter);
    }

    public void calcular(View v){
        int opcion;
        double num1,num2,resultado=0;
        opcion= operaciones.getSelectedItemPosition();
        num1= Double.parseDouble(n1.getText().toString());
        num2= Double.parseDouble(n2.getText().toString());

        switch (opcion){
            case 1:
                resultado = metodos.sumar(num1,num2);
                break;
            case 2:
                resultado = metodos.restar(num1,num2);
                break;
            case 3:
                resultado = metodos.multiplicar(num1,num2);
                break;
            case 4:
                resultado = metodos.dividir(num1,num2);
                break;


        }
        res.setText(""+String.format("%.2f",resultado));
    }


    public void limpiar (View v){

        n1.setText("");
        n2.setText("");
        operaciones.setSelection(0);
        n1.requestFocus();
        res.setText("");

    }

}
