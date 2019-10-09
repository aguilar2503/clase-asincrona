package mx.edu.ittepic.tpmd_u2_practica3_15400957

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.security.AccessControlContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var num1: EditText?=null
    var num2: EditText?=null
    var boton1: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.numero1)
        num2 = findViewById(R.id.numero2)
        boton1 = findViewById(R.id.generar)

        boton1?.setOnClickListener{
            Task1(num1?.text.toString(),num2?.text.toString(),applicationContext).execute()
        }


    }

    class Task1(num1:String ,num2:String,context: Context):AsyncTask<Void,Void, List<Int>>(){ //doInBackground
        var num1 = num1.toInt()
        var num2 = num2.toInt()

        override fun onPostExecute(result: List<Int>?) {
            super.onPostExecute(result)
            var cont =0;
            var et = "";
            var numerosPrimos="Numero primos: "
            (0..1999).forEach({
                cont =0
                et =result?.get(it).toString()
                (1..et.toInt()).forEach {
                    if (et.toInt() % it == 0) {
                        cont++
                    }
                }

            })
        }

        override fun doInBackground(vararg p0: Void?): List<Int> {
          val task = List (200){ Random.nextInt(num1,num2) }
            println(task)

            return task
        }




    }
}
