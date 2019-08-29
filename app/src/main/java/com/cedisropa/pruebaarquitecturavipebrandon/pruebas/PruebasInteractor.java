package com.cedisropa.pruebaarquitecturavipebrandon.pruebas;

import android.util.Log;

import com.cedisropa.pruebaarquitecturavipebrandon.api.APIPruebas;
import com.cedisropa.pruebaarquitecturavipebrandon.entities.Data;
import com.cedisropa.pruebaarquitecturavipebrandon.entities.StructureResponse;
import com.cedisropa.pruebaarquitecturavipebrandon.services.RetrofitClient;
import com.cedisropa.pruebaarquitecturavipebrandon.utils.ResourceProvider;
import com.cedisropa.sdk.WebServices;
import com.cedisropa.sdk.WebserviceNotFoundException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PruebasInteractor implements PruebasProvider{
    private static final String LOG_TAG = PruebasInteractor.class.getSimpleName();
    private ResourceProvider resourceProvider;

    private APIPruebas pruebasService;

    private PruebasObtainer obtainer;

    PruebasInteractor(PruebasObtainer obtainer,ResourceProvider resourceProvider){
        this.resourceProvider = resourceProvider;
        this.obtainer = obtainer;

        try {
            pruebasService = RetrofitClient.getService(APIPruebas.class, WebServices.
                    getService(9).getUrl().toString());
        } catch (WebserviceNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void obtenerNomSurtidor(String ip, int numTerminal, int numArea, int numSurtidor) {
        Call<StructureResponse<JsonObject>> call =
                pruebasService.validarSurtidor(ip, numTerminal, numArea, numSurtidor);
        call.enqueue(new Callback<StructureResponse<JsonObject>>() {
            @Override
            public void onResponse(Call<StructureResponse<JsonObject>> call,
                                   Response<StructureResponse<JsonObject>> response) {
                Data<JsonObject> data = response.body().getData();

                if(data.getStatus() == 1){
                    String nomSurtidor = data.getData().get("nomSurtidor").getAsString();
                    obtainer.responseObtenerNomSurtidor(nomSurtidor);
                }else{
                  //TODO: Avisar a usuario de error
                }
            }

            @Override
            public void onFailure(Call<StructureResponse<JsonObject>> call, Throwable t) {
                Log.e(LOG_TAG, "Error al validar surtidor", t);
            }
        });
    }
}
