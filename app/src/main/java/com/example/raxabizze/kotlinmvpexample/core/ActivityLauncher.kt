package com.example.raxabizze.kotlinmvpexample.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

object ActivityLauncher {
    fun go(context: Context, activityClass: Class<out Activity>, args: Bundle?) {
        val intent = Intent(context, activityClass)
        if (args != null) {
            intent.putExtras(args)
        }
        context.startActivity(intent)
    }
}
