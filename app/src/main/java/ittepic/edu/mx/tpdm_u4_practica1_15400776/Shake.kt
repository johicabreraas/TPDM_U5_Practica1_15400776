package ittepic.edu.mx.tpdm_u4_practica1_15400776

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class Shake (p:MainActivity): SensorEventListener {
    var puntero = p
    var lastUpdate: Long = 0
    var ejex = 0f
    var ejey = 0f
    var ejez = 0f
    var ejex2 = 0f
    var ejey2 = 0f
    var ejez2 = 0f

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent?) {
        var curTime: Long = System.currentTimeMillis()
        if ((curTime - lastUpdate) > 100) {
            var diffTime = (curTime - lastUpdate)
            lastUpdate = curTime;
            ejex = event!!.values[0]
            ejey = event!!.values[1]
            ejez = event!!.values[2]
            var speed: Float = Math.abs(ejex + ejey + ejez - ejex2 - ejey2 - ejez2) / diffTime * 10000;
            if (speed > 800) {
                puntero.countShake++
                if (puntero.countShake == 4) puntero.countShake = 0
            }
            ejex2 = ejex
            ejey2 = ejey
            ejez2 = ejez
        }
    }
}