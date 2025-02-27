package DAO;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import Model.Publicacions;
import java.util.concurrent.CompletableFuture;

public class PublicacionsDAO {
    private static final String API_URL = "https://oriolapi.vercel.app/publicacions";
    private HttpClient client;

    public PublicacionsDAO() {
        this.client = HttpClient.newHttpClient();
    }

    public void enviarPublicacio(Publicacions publicacio) {
        JSONObject json = new JSONObject();
        json.put("_id", publicacio.getId());
        json.put("text", publicacio.getText());
        json.put("hastags", new JSONArray(publicacio.getHastags()));
        json.put("mencions", new JSONArray(publicacio.getMencions()));
        json.put("paraules_clau", new JSONArray(publicacio.getParaules_clau()));
        json.put("data_hora", publicacio.getData_hora());
        json.put("likes", publicacio.getLikes());
        json.put("retuits", publicacio.getRetuits());
        json.put("ubicacio", publicacio.getUbicacio());
        json.put("sentiment", publicacio.getSentiment());
        json.put("usuari_id", publicacio.getUsuari_id());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CompletableFuture<ArrayList<Publicacions>> listarPublicacions() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        return responseFuture.thenApply(response -> {
            ArrayList<Publicacions> publicacions = new ArrayList<>();
            String responseBody = response.body();

            JSONArray jsonArray = new JSONArray(responseBody);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Publicacions publicacio = new Publicacions();
                publicacio.setId(jsonObject.getString("_id"));
                publicacio.setText(jsonObject.getString("text"));

                List<String> hastags = new ArrayList<>();
                JSONArray hashtagsArray = jsonObject.getJSONArray("hastags");
                for (int j = 0; j < hashtagsArray.length(); j++) {
                    hastags.add(hashtagsArray.getString(j));
                }
                publicacio.setHastags(hastags);

                List<String> mencions = new ArrayList<>();
                JSONArray mencionsArray = jsonObject.getJSONArray("mencions");
                for (int j = 0; j < mencionsArray.length(); j++) {
                    mencions.add(mencionsArray.getString(j));
                }
                publicacio.setMencions(mencions);

                List<String> paraulesClau = new ArrayList<>();
                JSONArray paraulesClauArray = jsonObject.getJSONArray("paraules_clau");
                for (int j = 0; j < paraulesClauArray.length(); j++) {
                    paraulesClau.add(paraulesClauArray.getString(j));
                }
                publicacio.setParaules_clau(paraulesClau);

                publicacio.setData_hora(jsonObject.getString("data_hora"));
                publicacio.setLikes(jsonObject.getInt("likes"));
                publicacio.setRetuits(jsonObject.getInt("retuits"));
                publicacio.setUbicacio(jsonObject.getString("ubicacio"));
                publicacio.setSentiment(jsonObject.getString("sentiment"));
                publicacio.setUsuari_id(jsonObject.getString("usuari_id"));

                publicacions.add(publicacio);
            }
            return publicacions;
        }).exceptionally(e -> {
            e.printStackTrace();
            return new ArrayList<>(); // Retornar una lista vacía en caso de error
        });
    }

    public int getLastId(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        return responseFuture.thenApply(response -> {
            String responseBody = response.body();
            JSONArray jsonArray = new JSONArray(responseBody);
            JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length()-1);
            return jsonObject.getInt("_id");
        }).exceptionally(e -> {
            e.printStackTrace();
            return 0; // Retornar 0 en caso de error
        }).join();
    }

}
