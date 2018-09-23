package com.reactsoft.safer.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import com.reactsoft.safer.ui.list.ListViewModel;
import com.reactsoft.safer.ui.detail.DetailsViewModel;
import com.reactsoft.safer.di.util.ViewModelKey;
import com.reactsoft.safer.util.ViewModelFactory;

// provee la instancias para que funciones las clases.
@Singleton
@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(DetailsViewModel detailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
