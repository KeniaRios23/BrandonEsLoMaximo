package com.cedisropa.pruebaarquitecturavipebrandon.pruebas;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cedisropa.pruebaarquitecturavipebrandon.R;
import com.cedisropa.pruebaarquitecturavipebrandon.utils.ResourceProvider;
import com.cedisropa.sdk.DatosGenerales;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PruebasActivity extends AppCompatActivity implements PruebasView {

    @BindView(R.id.txt_num_surtidor)
    EditText txtNumSurtidor;
    @BindView(R.id.lbl_nom_surtidor)
    TextView lblNomSurtidor;

    //Referencia al ViewPresenter
    private PruebasViewPresenter viewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);
        ButterKnife.bind(this);

        ResourceProvider resourceProvider = new ResourceProvider(this.getResources());
        this.viewPresenter = new PruebasPresenter(this, resourceProvider);


        DatosGenerales datosGenerales = new DatosGenerales();
        datosGenerales.setIpBodega("10.28.114.110");
        datosGenerales.setNumTerminal(1286);
        datosGenerales.setNumArea(1);

        viewPresenter.recibirDatosGenerales(datosGenerales);

        txtNumSurtidor.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_ENTER && txtNumSurtidor.length() > 0){
                    int numSurtidor = Integer.valueOf(txtNumSurtidor.getText().toString());
                    viewPresenter.obtenerNombreSurtidor(numSurtidor);
                }

                return false;
            }
        });
    }

    @Override
    public void mostrarNomSurtidor(String nomSurtidor) {
        lblNomSurtidor.setText(nomSurtidor);
    }
}
