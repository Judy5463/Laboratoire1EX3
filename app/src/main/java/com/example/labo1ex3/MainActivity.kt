package com.example.labo1ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var edA1: EditText
    private lateinit var edA2: EditText
    private lateinit var edB1: EditText
    private lateinit var edB2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnMoins: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDiv: Button
    private lateinit var btnMag: Button
    private lateinit var btnInDeg: Button
    private lateinit var btnInRad: Button
    private lateinit var btnConj: Button
    private lateinit var btnEgal: Button
    private lateinit var btnIsReal: Button
    private lateinit var btnIsImag: Button
    private lateinit var txtResultat: TextView
    private lateinit var z1: MyComplex
    private lateinit var z2: MyComplex

    var a1 = ""
    var a2 = ""
    var b1 = ""
    var b2 = ""
    var A1 = 0.0
    var A2 = 0.0
    var B1 = 0.0
    var B2 = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.edA1 = findViewById<EditText>(R.id.edA)
        this.edA2 = findViewById<EditText>(R.id.edA2)
        this.edB1 = findViewById<EditText>(R.id.edB1)
        this.edB2 = findViewById<EditText>(R.id.edB2)
        this.btnAdd = findViewById<Button>(R.id.btnAdd)
        this.btnMoins = findViewById<Button>(R.id.btnMoins)
        this.btnMulti = findViewById<Button>(R.id.btnMulti)
        this.btnDiv = findViewById<Button>(R.id.btnDiv)
        this.btnMag = findViewById<Button>(R.id.btnMag)
        this.btnInRad = findViewById<Button>(R.id.btnInRad)
        this.btnInDeg = findViewById<Button>(R.id.btnInDeg)
        this.btnConj = findViewById<Button>(R.id.btnConj)
        this.btnEgal = findViewById<Button>(R.id.btnEgal)
        this.btnIsReal = findViewById<Button>(R.id.btnIsReal)
        this.btnIsImag = findViewById<Button>(R.id.btnIsMag)
        this.txtResultat = findViewById<TextView>(R.id.txtResultat)

        this.btnAdd.setOnClickListener(View.OnClickListener {
            var saisi = Saisir()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                z2 = MyComplex(A2, B2)
                z1 = z1.add(z2)

                txtResultat.text = "LE RÉSULTAT :  " + z1.toString()
            }
        })
        this.btnMoins.setOnClickListener(View.OnClickListener {
            var saisi = Saisir()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                z2 = MyComplex(A2, B2)
                z1 = z1.subtract(z2)

                txtResultat.text = "LE RÉSULTAT : " + z1.toString()
            }
        })
        this.btnMulti.setOnClickListener(View.OnClickListener {
            var saisi = Saisir()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                z2 = MyComplex(A2, B2)
                z1 = z1.multiplyWith(z2)

                txtResultat.text = "LE RÉSULTAT : " + z1.toString()
            }
        })
        this.btnDiv.setOnClickListener(View.OnClickListener {
            var saisi = Saisir()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                z2 = MyComplex(A2, B2)
                z1 = z1.divideBy(z2)

                txtResultat.text = "LE RÉSULTAT : " + z1.toString()
            }
        })
        this.btnMag.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                var m = z1.magnitude()

                txtResultat.text = "LE RÉSULTAT : " + m.toString()
            }
        })
        this.btnInRad.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                var m = z1.argumentInRadians()

                txtResultat.text = "LE RÉSULTAT : " + m.toString()
            }
        })
        this.btnInDeg.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                var m = z1.argumentInDegrees()

                txtResultat.text = "LE RÉSULTAT : " + m.toString()
            }
        })
        this.btnConj.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {
                z1 = MyComplex(A1, B1)
                z2 = z1.conjugate()

                txtResultat.text = "LE RÉSULTAT : " + z2.toString()
            }
        })
        this.btnEgal.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {1
                z1 = MyComplex(A1, B1)
                z2 = MyComplex(A1, B1)
                z2.equals(z1)

                txtResultat.text = "LE RÉSULTAT : " + z2.toString()
            }
        })
        this.btnIsReal.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {1
                z1 = MyComplex(A1, B1)
                var b = z1.isReal()

                txtResultat.text = "LE RÉSULTAT : " + b.toString()
            }
        })
        this.btnIsImag.setOnClickListener(View.OnClickListener {
            var saisi = SaisirZ1()
            if(saisi == true) {1
                z1 = MyComplex(A1, B1)
                var b = z1.isImag()

                txtResultat.text = "LE RÉSULTAT : " + b.toString()
            }
        })
    }
    fun SaisirZ1():Boolean{
        var test:Boolean = true
        try{
            a1 = edA1.text.toString()
            b1 = edB1.text.toString()

            A1 = a1.toDouble()
            B1 = b1.toDouble()
            return true
        }catch (e:Exception){
            txtResultat.text = "ATTENTION UNE ERREUR EST SURVENUE!"
            return false
        }
    }

    fun Saisir():Boolean{
        var test:Boolean = true
        try{
            a1 = edA1.text.toString()
            a2 = edA2.text.toString()
            b1 = edB1.text.toString()
            b2 = edB2.text.toString()

            A1 = a1.toDouble()
            A2 = a2.toDouble()
            B1 = b1.toDouble()
            B2 = b2.toDouble()
            return true
        }catch (e:Exception){
            txtResultat.text = "ATTENTION UNE ERREUR EST SURVENUE!"
            return false
        }
    }
}