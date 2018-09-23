package com.reactsoft.safer.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.reactsoft.safer.ui.main.MainActivity;
import com.reactsoft.safer.ui.main.MainFragmentBindingModule;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
