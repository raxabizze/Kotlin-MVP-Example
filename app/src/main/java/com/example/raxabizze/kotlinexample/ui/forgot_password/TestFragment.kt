package com.example.raxabizze.kotlinexample.ui.forgot_password

import android.os.Bundle
import android.util.Log as L
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raxabizze.kotlinexample.R
import com.example.raxabizze.kotlinexample.base.BaseFragment
import com.example.raxabizze.kotlinexample.ui.login.LoginData
import com.example.raxabizze.kotlinexample.utils.sum
import javax.inject.Inject

class TestFragment : BaseFragment() {
    @Inject
    internal lateinit var mLoginData: LoginData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View = inflater.inflate(R.layout.fragment_forgot_password, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        9.sum(1)


        mLoginData.account = "FDag"
        L.e("hgsf", mLoginData.account)

        val car1 = Car("blue", "Toyota", 1992)
        val car2 = Car("yellow", "Toyota", 1982)
        val car3 = Car("red", "Toyota", 1972)
        printColors(car1, car2, car3, str = "print: ")
        //printColors("print: ", car1, car2, car3)

        val manyCars = arrayOf(car1, car2, car3)
        printColors(*manyCars)

        val moreCars = arrayOf(car2, car3)
        val car4 = car2.copy()
        val lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
        for (c in lotsOfCars) {
            print(c)
        }

        println("abc".upperFirstAndLaast())

        wantSomeInterface(object: SomeInterface {
          override fun mustImplament(num: Int) =
                  "This is form mustImplment: ${num * 100}"
        })


        val stringVariable: String? = "abc"

        stringVariable?.let {
            nonNullString ->
            println("The non null string is $nonNullString")
        }

        stringVariable?.let {
            print("The String is $it")
             it.reversed()
        }?.let {
            print("The String is $it")
            it.length
        }.let {
            print("The Length is $it")
        }
    }


    //fun printColors (str: String, vararg  cars: Car) {
    fun printColors (vararg  cars: Car, str: String = "") {
        for (car in cars) print(car.color)
    }

    data class Car(val color: String, val model: String, val year: Int)

    // extension function
    fun String.upperFirstAndLaast (): String {
        val upperFirst = substring(0,1).toUpperCase() + substring(1)
        //val upperFirst = this.substring(0,1).toUpperCase() + this.substring(1)
        return upperFirst.substring(0, upperFirst.length - 1) +
                upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
    }




    interface SomeInterface {
        fun mustImplament(num: Int): String
    }

    fun wantSomeInterface(si: SomeInterface) {
        println("Printing from wantSomeInterface ${si.mustImplament(22)}")
    }

}
