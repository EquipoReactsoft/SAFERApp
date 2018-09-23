package com.reactsoft.safer.base;

import com.reactsoft.safer.di.component.ApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import com.reactsoft.safer.di.component.DaggerApplicationComponent;

public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    } // 3

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
         // DaggerApplicationComponent hace referencia al Componente
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this); // 1

        return component; //2
    }
}
