package ittepic.edu.mx.tpdm_u4_practica1_15400776

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:Linezo,xpos:Float,ypos:Float,id_img:Int) {
    var ejex = xpos
    var ejey = ypos
    var imagen = BitmapFactory.decodeResource(l.resources,id_img)

    fun pintar(c: Canvas){
        c.drawBitmap(imagen,ejex,ejey, Paint())


    }

    fun estaEnArea(toquex:Float,toquey:Float):Boolean{
        var x2 = ejex+imagen.width
        var y2 = ejey+imagen.height

        if(toquex >= ejex && toquex <= x2){
            if(toquey >= ejey && toquey <= y2){
                return true
            }
        }

        return false
    }

    fun mover(xCoor:Float){
        ejex = ejex+(xCoor)
    }
}