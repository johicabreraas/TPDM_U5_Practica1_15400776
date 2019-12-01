package ittepic.edu.mx.tpdm_u4_practica1_15400776

import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.ArrayList

class Linezo(p:MainActivity): View(p) {

    var puntero = p
    var facebook = Imagen(this, 100f, 650f, R.drawable.facebookcolor)
    var instagram = Imagen(this, 100f, 250f, R.drawable.instagramcolor)
    var twitter = Imagen(this, 360f, 1050f, R.drawable.twittercolor)
    var whatsapp = Imagen(this, 650f, 250f, R.drawable.whatsappcolor)
    var youtube = Imagen(this, 650f, 650f, R.drawable.youtubecolor)

    var facebookblack = Imagen(this, 100f, 650f, R.drawable.bnfacebook)
    var instagramblack = Imagen(this, 100f, 250f, R.drawable.bninstagram)
    var twitterblack = Imagen(this, 360f, 1050f, R.drawable.bntwitter)
    var whatsappblack = Imagen(this, 650f, 250f, R.drawable.bnwhatsapp)
    var youtubeblack = Imagen(this, 650f, 650f, R.drawable.bnyoutube)

    var facebook_vintage = Imagen(this, 100f, 650f, R.drawable.facebookvintage)
    var instagram_vintage = Imagen(this, 100f, 250f, R.drawable.instagramvintage)
    var twitter_vintage = Imagen(this, 360f, 1050f, R.drawable.twittervintage)
    var whatsapp_vintage = Imagen(this, 650f, 250f, R.drawable.whatsappvintage)
    var youtube_vintage = Imagen(this, 650f, 650f, R.drawable.youtubevintage)

    var facebook_antiguo = Imagen(this, 100f, 650f, R.drawable.facebookantiguo)
    var instagram_antiguo = Imagen(this, 100f, 250f, R.drawable.instagramantiguo)
    var twitter_antiguo = Imagen(this, 360f, 1050f, R.drawable.twitterantiguo)
    var whatsapp_antiguo = Imagen(this, 650f, 250f, R.drawable.whatsappantiguo)
    var youtube_antiguo = Imagen(this, 650f, 650f, R.drawable.youtubeantiguo)

    var arrayColor = arrayListOf<Imagen>(facebook,instagram,twitter,whatsapp,youtube)
    var arrayBN = arrayListOf<Imagen>(facebookblack,instagramblack,twitterblack,whatsappblack,youtubeblack)
    var arrayVintage = arrayListOf<Imagen>(facebook_vintage,instagram_vintage,twitter_vintage,whatsapp_vintage,youtube_vintage)
    var arrayAntiguo = arrayListOf<Imagen>(facebook_antiguo,instagram_antiguo,twitter_antiguo,whatsapp_antiguo,youtube_antiguo)
    var picono: Imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if(puntero.distancia == 0f){
            Toast.makeText(puntero,"Oculto", Toast.LENGTH_SHORT).show()
        }
        else{
            when (puntero.countShake) {
                0 -> {
                    drawImgs(arrayColor, c)
                    moverImagenes(arrayColor, puntero.x)
                }
                1 -> {
                    drawImgs(arrayBN, c)
                    moverImagenes(arrayBN, puntero.x)
                }
                2 -> {
                    drawImgs(arrayVintage, c)
                    moverImagenes(arrayVintage, puntero.x)
                }
                3 -> {
                    drawImgs(arrayAntiguo, c)
                    moverImagenes(arrayAntiguo, puntero.x)
                }
            }

        }

    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {
                if(facebook.estaEnArea(e.getX(),e.getY())||
                    facebookblack.estaEnArea(e.getX(),e.getY())||
                    facebook_vintage.estaEnArea(e.getX(),e.getY())||
                    facebook_antiguo.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Toco Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = facebook

                }
                if(instagram.estaEnArea(e.getX(),e.getY())||
                    instagramblack.estaEnArea(e.getX(),e.getY())||
                    instagram_vintage.estaEnArea(e.getX(),e.getY())||
                    instagram_antiguo.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Toco Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = instagram
                }
                if(twitter.estaEnArea(e.getX(),e.getY())||
                    twitterblack.estaEnArea(e.getX(),e.getY())||
                    twitter_vintage.estaEnArea(e.getX(),e.getY())||
                    twitter_antiguo.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Toco Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = twitter
                }
                if(whatsapp.estaEnArea(e.getX(),e.getY())||
                    whatsappblack.estaEnArea(e.getX(),e.getY())||
                    whatsapp_vintage.estaEnArea(e.getX(),e.getY())||
                    whatsapp_antiguo.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Toco Whatsapp", Toast.LENGTH_SHORT)
                        .show()
                    picono = whatsapp
                }
                if(youtube.estaEnArea(e.getX(),e.getY())||
                    youtubeblack.estaEnArea(e.getX(),e.getY())||
                    youtube_vintage.estaEnArea(e.getX(),e.getY())||
                    youtube_antiguo.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Toco YouTube", Toast.LENGTH_SHORT)
                        .show()
                    picono = youtube
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }

        }
        return true
    }

    fun moverImagenes(arrayImagenes: ArrayList<Imagen>, x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }

    fun drawImgs(arrayImagenes: ArrayList<Imagen>, c: Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}
