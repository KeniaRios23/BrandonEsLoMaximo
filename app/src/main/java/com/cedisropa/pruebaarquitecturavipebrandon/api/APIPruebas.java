package com.cedisropa.pruebaarquitecturavipebrandon.api;

import com.cedisropa.pruebaarquitecturavipebrandon.entities.StructureResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIPruebas {
    @GET("validarSurtidor/{ip}/{numTerminal}/{numArea}/{numSurtidor}")
    Call<StructureResponse<JsonObject>> validarSurtidor(
            @Path("ip") String ip,
            @Path("numTerminal") int numTerminal,
            @Path("numArea") int numArea,
            @Path("numSurtidor") int numSurtidor
    );
}
