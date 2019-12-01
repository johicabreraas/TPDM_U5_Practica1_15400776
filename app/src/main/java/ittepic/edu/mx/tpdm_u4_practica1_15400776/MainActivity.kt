package ittepic.edu.mx.tpdm_u4_practica1_15400776

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var sensorManager: SensorManager?= null
    var sensorProximidad : Proximidad ?= null
    var sensorAcelerometro : Acelerometro ?= null
    var sensorShake : Shake ?= null
    var x = 0f
    var countShake = 0
    var distancia = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Linezo(this))

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorProximidad = Proximidad(this)
        sensorAcelerometro = Acelerometro(this)
        sensorShake = Shake(this)
        sensorManager?.registerListener(sensorProximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_UI)

        sensorManager?.registerListener(sensorAcelerometro,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager?.registerListener(sensorShake,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)

    }

}