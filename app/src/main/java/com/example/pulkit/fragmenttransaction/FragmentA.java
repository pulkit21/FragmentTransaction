package com.example.pulkit.fragmenttransaction;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pulkit on 8/14/15.
 */
public class FragmentA extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        Log.d("PUL", "Frag A onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("PUL", "Frag A onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("PUL", "Frag A onCreateVIew");
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("PUL", "Frag A onActCreate");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        Log.d("PUL", "Frag A onPause");
        super.onPause();
    }



    @Override
    public void onStop() {
        Log.d("PUL", "Frag A onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("PUL", "Frag A onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("PUL", "Frag A onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("PUL", "Frag A onDetach");
        super.onDetach();
    }
}
