package com.reactsoft.safer.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.reactsoft.safer.base.BaseActivity;

import com.reactsoft.safer.R;
import com.reactsoft.safer.data.enums.FirebaseReferences;
import com.reactsoft.safer.ui.list.ListFragment;

import dagger.multibindings.LongKey;

public class MainActivity extends BaseActivity{

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        DatabaseReference references = database.getReference(FirebaseReferences.REPORTES_REFERENCE);
//
//        // get value
//        Log.i("KEY === ", references.getKey());
//
//        references.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                int valor = dataSnapshot.getValue(Integer.class);
//                Log.i("My Key on Change :", valor + "");
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.i("Error :", databaseError.getMessage());
//            }
//        });

        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new ListFragment()).commit();
    }
}
