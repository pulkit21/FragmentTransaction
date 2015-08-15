package com.example.pulkit.fragmenttransaction;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener, MyDialog.Communicator {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
    }

    public void addButtA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.group, fragmentA, "A");
        fragmentTransaction.addToBackStack("addButtA");
        fragmentTransaction.commit();

    }

    public void addButtB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.group, fragmentB, "B");
        fragmentTransaction.addToBackStack("addButtB");
        fragmentTransaction.commit();

    }

    public void removeButtA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        if (fragmentA != null) {
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.addToBackStack("removeButtA");
            fragmentTransaction.commit();
        }
        else {
            Toast.makeText(this,"Frag A is not added",Toast.LENGTH_SHORT).show();
        }

    }

    public void replaceButtA(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, fragmentB,"B");
        fragmentTransaction.addToBackStack("replaceButtA");
        fragmentTransaction.commit();
    }

    public void replaceButtB(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group,fragmentA, "A");
        fragmentTransaction.addToBackStack("replaceButtB");
        fragmentTransaction.commit();

    }

    public void attachButtA(View view) {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null) {
            fragmentTransaction.attach(fragmentA);
            fragmentTransaction.addToBackStack("attachButtA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this,"Frag A is not added",Toast.LENGTH_SHORT).show();
        }

    }

    public void deattachButtA(View view) {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentA != null) {
            fragmentTransaction.detach(fragmentA);
            fragmentTransaction.addToBackStack("deattachButtA");
            fragmentTransaction.commit();
        }else {
            Toast.makeText(this,"Frag A is not added",Toast.LENGTH_SHORT).show();
        }
    }

    public void showDialog(View view) {
        MyDialog myDialog = new MyDialog();
        FragmentManager fragmentManager = getFragmentManager();
        myDialog.show(fragmentManager,"MyDialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged() {



    }

    @Override
    public void onDialogClick(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
