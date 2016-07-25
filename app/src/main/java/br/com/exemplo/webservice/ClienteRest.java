package br.com.exemplo.webservice;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import model.exemplo.com.br.consumirws.Cliente;

/**
 * Created by ROGERIO on 24/07/2016.
 */
public class ClienteRest {

    private static final String URL_WS = "https://c7q5vyiew7.execute-api.us-east-1.amazonaws.com";

    public Cliente getCliente(int id) throws Exception {

        String[] resposta = new webServiceCliente().get(URL_WS + id);

        if (resposta[0].equals("200")) {
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(resposta[1],Cliente.class);
            return cliente;
        } else {
            throw new Exception(resposta[1]);
        }
    }

    public List<Cliente> getListaCliente() throws Exception {

        String[] resposta = new webServiceCliente().get(URL_WS + "buscarTodosGSON");
//       String[] resposta = new WebServiceCliente().get(URL_WS + "buscarTodos");

        if (resposta[0].equals("200")) {
            Gson gson = new Gson();
            ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
            JsonParser parser = new JsonParser();
            JsonArray array = parser.parse(resposta[1]).getAsJsonArray();

            for (int i = 0; i < array.size(); i++) {
                listaCliente.add(gson.fromJson(array.get(i), Cliente.class));
            }
            return listaCliente;
        } else {
            throw new Exception(resposta[1]);
        }
    }

    public String inserirCliente(Cliente cliente) throws Exception {

        Gson gson = new Gson();
        String clienteJSON = gson.toJson(cliente);
        String[] resposta = new webServiceCliente().post(URL_WS+"inserir",clienteJSON);
        // WebServiceCliente().post(URL_WS + "inserir", clienteJSON);
        if (resposta[0].equals("200")) {
            return resposta[1];
        } else {
            throw new Exception(resposta[1]);
        }
    }

}


