package com.example.raxabizze.kotlinexample.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun FragmentActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }
}

fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
        beginTransaction().func().commit()


//var sd = Retrofit.Builder().onSetUrl("https://")
fun Retrofit.Builder.onSetUrl(url: String): Unit {
    setting {
        baseUrl(url)
    }
}

inline fun Retrofit.Builder.setting(funct: Retrofit.Builder.() -> Retrofit.Builder) =
        funct().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()


//fun Context.toast(message:CharSequence)= Toast.makeText(this,message, Toast.LENGTH_LONG).show()

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

// => 1.sum(2)
val sum: Int.(other: Int) -> Int = { it + this }

fun Int.sun(x : Int): Int {
    return this + x
}


// 1 infix_sum 2
infix fun Int.infix_sum(x: Int): Int {
    return x + this
}

//val sum = { x: Int, y: Int -> x + y }
//Log.e("answer", "" + max(1,sum))
//=> 3
fun max(x: Int, less: (Int, Int) -> Int): Int {
    return x + less(x, x)
}


fun String.count(): Int {
    return length
}


//fun ImageView.loadUrl(url: String) {
//    Picasso.with(context).load(url).into(this)
//}
//inline fun <reified T : ViewModel> Fragment.viewModel(factory: Factory, body: T.() -> Unit): T {
//    val vm = ViewModelProviders.of(this, factory)[T::class.java]
//    vm.body()
//    return vm
//}