package com.blackdish.blackdishar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blackdish.blackdishar.controllers.ArController;
import com.blackdish.blackdishar.models.ArPlateModel;
import com.google.ar.sceneform.ux.ArFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArFragment arFragment;
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        ArController arController = new ArController(arFragment);
        ArPlateModel arPlateModel = new ArPlateModel();
        arPlateModel.setImagenPlatillo("https://blackdish.mx/blackdish-beta-v3/backend/model/img_admin/IMG-5477-removebg-preview.png"); //por ahora usamos este como placeholder para hacer las pruebas del arController
        arController.setPlateModel(arPlateModel);
        arController.setContext(getApplicationContext());
        Button button = findViewById(R.id.addAr);
        arController.draw();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}
