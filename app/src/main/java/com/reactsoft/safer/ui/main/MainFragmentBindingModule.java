package com.reactsoft.safer.ui.main;

import com.reactsoft.safer.ui.detail.DetailsFragment;
import com.reactsoft.safer.ui.list.ListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ListFragment provideListFragment();

    @ContributesAndroidInjector
    abstract DetailsFragment provideDetailsFragment();
}
