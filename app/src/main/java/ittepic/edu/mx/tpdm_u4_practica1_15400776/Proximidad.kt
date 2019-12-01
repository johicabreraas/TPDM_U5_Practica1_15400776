package ittepic.edu.mx.tpdm_u4_practica1_15400776

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.Toast

class Proximidad (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent?) {
        puntero.distancia = event!!.values[0]
        if (event!!.values[0]==0f)
            Toast.makeText(puntero,"Se Ocultaron los Iconos", Toast.LENGTH_SHORT)
                .show()
    }
}