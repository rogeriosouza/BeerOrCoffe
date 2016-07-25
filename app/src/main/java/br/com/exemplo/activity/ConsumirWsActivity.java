package br.com.exemplo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.exemplo.webservice.ClienteRest;
import model.exemplo.com.br.consumirws.Cliente;
import model.exemplo.com.br.consumirws.R;

/**
 * Created by ROGERIO on 24/07/2016.
 */
public class ConsumirWsActivity extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final TextView txtvView = (TextView) findViewById(R.id.textView);
        Button inserirBtn =(Button) findViewById(R.id.btnInserirCliente);

        inserirBtn.setOnClickListener(new View.OnClickListener()  {


            public void onClick(View v) {
                Cliente cliente = new Cliente();
                cliente.setNome("Cafe - taberna");
                cliente.setEndereco("Rua Casa do Ator, 919 - Vila Olímpia - São Paulo, SP");
                cliente.setLatitude("-23.5976730");
                cliente.setLongetitude("-46.6820624");
                cliente.setBebida(2);

                ClienteRest cliREST = new ClienteRest();
                try {
                    String resposta = cliREST.inserirCliente(cliente);
                    txtvView.setText(resposta);
                } catch (Exception e) {
                    e.printStackTrace();
                    gerarToast(e.getMessage());
                }
            }



        });



    }

    private void gerarToast(CharSequence message) {
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast
                .makeText(getApplicationContext(), message, duration);
        toast.show();
    }

}
