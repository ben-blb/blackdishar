package com.blackdish.blackdishar.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.blackdish.blackdishar.R;
import com.blackdish.blackdishar.classes.ImageDownloader;
import com.blackdish.blackdishar.models.ArPlateModel;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ArController {
    private ArPlateModel plateModel;
    private ArFragment arFragment;
    ViewRenderable platilloR;
    private Context context;

    public ArController(ArFragment viewer){

        arFragment = viewer;
    }

    public void setPlateModel(ArPlateModel plateModel) {
        this.plateModel = plateModel;
    }

    public void draw() {
        arFragment.getPlaneDiscoveryController().hide();
        arFragment.getPlaneDiscoveryController().setInstructionView(null);
        ViewRenderable.builder()
                .setView(context, R.layout.activity_plato)
                .build()
                .thenAccept(renderable ->{
                    ImageView imgView = (ImageView) renderable.getView();
                    ImageDownloader imageDownloader = new ImageDownloader();
                    try{
                        Bitmap downloadedMonita = imageDownloader.execute(plateModel.getImagenPlatillo()).get();
                        imgView.setImageBitmap(downloadedMonita);
                        platilloR = renderable;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                })
                .exceptionally(
                        throwable -> {
                            //toast
                            return null;
                        });
        arFragment.setOnTapArPlaneListener((HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
            if(platilloR == null){
                return;
            }
            platilloR.setShadowCaster(false);
            platilloR.setShadowReceiver(false);
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());
            TransformableNode monachina = new TransformableNode(arFragment.getTransformationSystem());
            monachina.setParent(anchorNode);
            monachina.setRenderable(platilloR);
            monachina.select();
        });
    }

    public void setContext(Context context1){
        context = context1;
    }
}