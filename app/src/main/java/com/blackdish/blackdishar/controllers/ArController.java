package com.blackdish.blackdishar.controllers;

import com.blackdish.blackdishar.models.ArPlateModel;
import com.google.ar.sceneform.ux.ArFragment;

public class ArController {
    private ArPlateModel plateModel;
    private ArFragment arFragment;
    public ArController(ArFragment viewer){
        arFragment = viewer;
    }

    public void setPlateModel(ArPlateModel plateModel) {
        this.plateModel = plateModel;
    }

    public void draw() {
    }
}
