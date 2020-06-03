package com.blackdish.blackdishar.models;

public class ArPlateModel {
    private double _costo;
    private String _descripcion;
    private int idPlatillo;
    private String imagenPlatillo;
    private String nombre;

    public void set_costo(double _costo) {
        this._costo = _costo;
    }

    public double get_costo() {
        return _costo;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setImagenPlatillo(String imagenPlatillo) {
        this.imagenPlatillo = imagenPlatillo;
    }

    public String getImagenPlatillo() {
        return imagenPlatillo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
