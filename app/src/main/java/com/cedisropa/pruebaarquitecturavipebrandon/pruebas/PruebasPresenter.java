package com.cedisropa.pruebaarquitecturavipebrandon.pruebas;

import com.cedisropa.pruebaarquitecturavipebrandon.utils.ResourceProvider;
import com.cedisropa.sdk.DatosGenerales;

public class PruebasPresenter implements PruebasViewPresenter, PruebasObtainer{
    ResourceProvider resourceProvider;
    private DatosGenerales datosGenerales;

    private PruebasProvider provider;

    private PruebasView view;

    public PruebasPresenter(PruebasView view,ResourceProvider resourceProvider){
        this.resourceProvider = resourceProvider;
        this.provider = new PruebasInteractor(this,resourceProvider);
        this.view = view;
    }

    @Override
    public void recibirDatosGenerales(DatosGenerales datosGenerales) {
        this.datosGenerales = datosGenerales;
    }

    @Override
    public void obtenerNombreSurtidor(int numSurtidor) {
        provider.obtenerNomSurtidor(datosGenerales.getIpBodega(), datosGenerales.getNumTerminal(),
                datosGenerales.getNumArea(), numSurtidor);
    }

    @Override
    public void responseObtenerNomSurtidor(String nomSurtidor) {
        view.mostrarNomSurtidor(nomSurtidor);
    }
}
