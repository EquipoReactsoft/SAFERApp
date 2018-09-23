package com.reactsoft.safer.di.component;

import android.app.Application;

import com.reactsoft.safer.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import com.reactsoft.safer.base.BaseApplication;
import com.reactsoft.safer.di.module.ActivityBindingModule;
import com.reactsoft.safer.di.module.ContextModule;

/**
 * Es el puente de comunicacion de los modulos y la linea que solicita los objectos.
  */
@Singleton
@Component(modules = {  ContextModule.class
                        ,ApplicationModule.class
                        ,AndroidSupportInjectionModule.class
                        ,ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}