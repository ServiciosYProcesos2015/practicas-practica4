package es.florida_uni.dam.practica4;


import android.os.AsyncTask;
import android.util.Log;


//<Params, Progress, Result>
public class TareaMuyCostosa extends AsyncTask<Integer, Integer, String>{

    final static String TAG = "SYP-practica4";

    MainActivity actividadPadre;

    public TareaMuyCostosa(MainActivity actividadPadre){
        this.actividadPadre = actividadPadre;
    }

    //--------------------------------------------------------------------------
    // DEBES PROGRAMAR LAS FUNCIONES DEL TEMPLATE PARA QUE SUCEDA LO SIGUIENTE:
    //--------------------------------------------------------------------------

    // TODO: Ejecutar el siguiente código principal de la tarea
                /*
                int numEjecuciones;

                Log.i(TAG, "Tarea muy costosa iniciada");

                // TODO: Obtener el número de ejecucuiones a realizar
                numEjecuciones = params[0];

                try {
                    for(int i=0;i<numEjecuciones;i++){
                        if(meHanInterrumpido()) return "CANCELADA";
                        Log.i(TAG, "Tarea muy costosa en marcha...");
                        // TODO: actualizar el progreso
                        // IMPORTANTE: No llames directamente a mostrarProgreso. Algunas veces te
                        // funcionará (puede que siempre) pero en una aplicación real dará errores

                        Thread.sleep(50);
                    }
                    Log.i(TAG, "Proceso de la tarea costosa terminado");
                }catch(InterruptedException e){
                    return "CANCELADA";
                }

                Log.i(TAG, "Tarea muy costosa finalizada");

                return "TERMINADA";
                */


    // TODO: Invocar a la función inicializarProgreso antes de que se ejecute la tarea
    // TODO: Llamar a la función que actualiza el progreso
    // TODO: Invocar a la función notificarFinalizacion cuando acaba bien
    // TODO: Invocar a la función notificarFinalizacion cuando la tarea ha sido cancelada


    // TODO: modifica esta función para devolver true cuando la tarea se haya interrumpido
    private boolean meHanInterrumpido(){
        return false;
    }


    // Inicializar la barra de progreso
    // Debéis llamar a esta función desde donde corresponda
    private void inicializarProgreso(){
        mostrarProgreso(0);
    }

    // Mostrar el progreso en la barra principal conforme la tarea avance
    // Debéis llamar a esta función desde donde corresponda
    // e implementarla para que actualice la barra de progreso
    private void mostrarProgreso(final int progreso) {
        actividadPadre.barraProgreso.setProgress(progreso);
    }

    // Avisar de la finalización de la tarea
    // Debéis llamar a esta función donde corresponda
    private void notificarFinalizacion(String result){
        actividadPadre.tareaMuyCostosaFinalizada(result);
    }

}
