package com.example.labo1ex3

class MyComplex (_real:Double,_imag:Double) {
    private  var real:Double
    private var imag:Double

    init{
        this.real = _real
        this.imag = _imag
    }

    fun getReal() = this.real
    fun setReal(n:Double){
        this.real = n
    }

    fun getImag() = this.imag
    fun setImag(n:Double){
        this.imag = n
    }

    fun setValue(x:Double,y:Double){
        this.real = x
        this.imag = y
    }

    override fun toString():String{
        return String.format("(%g %+gi)" ,real,imag)
    }
    fun isReal():Boolean{
        var z1 = this.imag
        if(z1 == 0.0) {
            return true
        }
        return false
    }
    fun isImag():Boolean{
        var z1 = this.imag
        if(z1 == 0.0) {
            return false
        }
        return true
    }
    fun equals(real:Double,imag:Double):MyComplex{
        this.real = real
        this.imag = imag
        return this
    }
    fun equals(another:MyComplex):MyComplex{
        this.real = another.real
        this.imag = another.imag
        return this
    }
    fun magnitude():Double{
        return Math.pow(this.real * this.real + this.imag * this.imag,0.5)
    }
    fun argumentInRadians():Double{
        return Math.atan2(this.imag,this.real)
    }
    fun argumentInDegrees():Int{
        return (argumentInRadians()*360/(2*Math.PI)).toInt()
    }
    fun conjugate():MyComplex{
        var z1 = MyComplex(this.real,-this.imag)
        return z1
    }
    fun add(another:MyComplex):MyComplex{
        var z1 = this
        var z2 = another
        var z3 = MyComplex(z1.real + z2.real,z1.imag + z2.imag)
        return z3
    }
    fun subtract(another:MyComplex):MyComplex{
        var z1 = this
        var z2 = another
        var z3 = MyComplex(z1.real - z2.real,z1.imag - z2.imag)
        return z3
    }
    fun multiplyWith(another:MyComplex):MyComplex{
        var z1 = this
        var z2 = another
        var z3 = MyComplex((z1.real * z2.real) - (z1.imag * z2.imag),(z1.real * z2.imag)+ (z2.real * z1.imag))
        return z3
    }
    fun divideBy(another:MyComplex):MyComplex{
        var z1 = this
        var z2 = another
        var z2Conj = z2.conjugate()
        var z4 = multiplyWith(z2Conj)
        var z5 = z2.multiplyWith(z2Conj)
        var z6 = MyComplex(z4.real/z5.real,z4.imag/z5.real)
        return z6
    }

}