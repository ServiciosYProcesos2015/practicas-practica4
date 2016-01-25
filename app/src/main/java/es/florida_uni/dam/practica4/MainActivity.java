package es.florida_uni.dam.practica4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    final static String TAG = "SYP-practica4";

    TareaMuyCostosa tareaMuyCostosa;
    public ProgressBar barraProgreso;


    protected void tareaMuyCostosaFinalizada(String result){
        // Aqui podríamos actualizar el interface de usuario, etc.
        Log.i(TAG, "Tratamiento del mensaje de finalización de la tarea muy costosa");
        tareaMuyCostosa = null;
        Toast.makeText(
                this, "¡Tarea muy costosa finalizada! Ha finalizado con el resultado "+result, Toast.LENGTH_SHORT
                ).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barraProgreso = (ProgressBar) findViewById(R.id.barraProgreso);

        instalarManejadores();
    }

    private void instalarManejadores(){
        Button btnTareaCostosa = (Button) findViewById(R.id.btnTareaCostosa);
        Button btnSaludar = (Button) findViewById(R.id.btnSaludar);
        Button btnDetener = (Button) findViewById(R.id.btnDetener);

        // Manejador del botón de saludar
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "Saludando");
                Toast.makeText(
                        MainActivity.this, "Hola", Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Manejador del botón que ejecuta la tarea costosa
        btnTareaCostosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "Ejecutando tarea muy costosa");
                ejecutarTareaMuyCostosa();
            }
        });


        // Manejador del botón que detiene la tarea costosa
        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "Deteniendo tarea muy costosa");
                detenerTareaMuyCostosa();
            }
        });
    }

    // Lanzamiento de la tarea muy costosa
    private void ejecutarTareaMuyCostosa(){
        if(tareaMuyCostosaEjecutandose()) {
            Log.i(TAG, "La tarea muy costosa ya se estaba ejecutando");
            return;
        }

        tareaMuyCostosa = new TareaMuyCostosa(this);
        // TODO: arrancar la tarea muy costosa haciendo que se ejecute barraProgreso.getMax() veces
    }

    // Detención de la tarea muy costosa
    private void detenerTareaMuyCostosa(){
        if(!tareaMuyCostosaEjecutandose()) {
            Log.i(TAG, "La tarea muy costosa no se estaba ejecutando, no se puede detener");
            return;
        }

        // TODO: Detener la tarea muy costosa


        // Poner a null para poder volver a lanzar
        tareaMuyCostosa = null;
    }

    private boolean tareaMuyCostosaEjecutandose(){
        return tareaMuyCostosa != null;
    }

}
