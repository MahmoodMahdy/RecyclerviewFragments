package com.mahdy.codes.chalengefragmentrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Caradapter.ItemClecked {
    Button btnCarInfo , btnOwnerInfo  ;
    ImageView ivMake ;
    TextView tvModel ,tvName, tvTel ;
    FragmentManager fragmentManager ;
    Fragment listFrag , ownerInfoFrag , carInfoFrag , buttonFrag ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarInfo = (Button) findViewById(R.id.btnCarInfo) ;
        btnOwnerInfo = (Button) findViewById(R.id.btnOwnerInfo) ;
        ivMake =(ImageView) findViewById(R.id.ivMake) ;
        tvModel =(TextView) findViewById(R.id.tvModel) ;
        tvName =(TextView) findViewById(R.id.tvName) ;
        tvTel =(TextView) findViewById(R.id.tvTel) ;

        fragmentManager = getSupportFragmentManager() ;
        listFrag = fragmentManager.findFragmentById(R.id.ListFrag) ;
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag) ;
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        buttonFrag = fragmentManager .findFragmentById(R.id.btnsFrag) ;

        fragmentManager.beginTransaction().show(listFrag)
                .show(buttonFrag)
                .show(carInfoFrag)
                .hide(ownerInfoFrag)
                .commit() ;


        onItemClecked(0);
        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(ownerInfoFrag)
                        .commit() ;
            }
        });
        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(ownerInfoFrag)
                        .commit() ;
            }
        });

    }

    @Override
    public void onItemClecked(int position) {

        tvModel.setText(ApplicationCar.cars.get(position).getModel());
        tvName.setText(ApplicationCar.cars.get(position).getOwnerName());
        tvTel.setText(ApplicationCar.cars.get(position).getOwnerTel());

        if (ApplicationCar.cars.get(position).getMake().equals("Mercedes")){
            ivMake.setImageResource(R.drawable.mercedes);
        }else
        if (ApplicationCar.cars.get(position).getMake().equals("Volksvegen")){
            ivMake.setImageResource(R.drawable.volkswagen);
        } else {
            ivMake.setImageResource(R.drawable.nissan);
        }

    }
}
