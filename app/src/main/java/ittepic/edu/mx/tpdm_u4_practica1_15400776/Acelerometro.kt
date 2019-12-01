package ittepic.edu.mx.tpdm_u4_practica1_15400776

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class Acelerometro (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
    override fun onSensorChanged(event: SensorEvent?) {
        puntero.x = event!!.values[0]
    }
}