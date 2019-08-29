package com.cedisropa.pruebaarquitecturavipebrandon.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data<T> {
    @SerializedName("STATUS")
    @Expose
    private Integer status;

    @SerializedName("MENSAJE")
    @Expose
    private String mensaje;

    @SerializedName("DATA")
    @Expose
    private T data;

    public Integer getStatus() { return this.status; }
    public void setStatus(Integer status) { this.status = status; }

    public String getMensaje() { return this.mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public T getData() { return this.data; }
    public void setData(T data) { this.data = data; }
}
