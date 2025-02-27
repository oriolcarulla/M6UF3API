package Model;

import org.json.JSONObject;

import java.util.List;

public class Publicacions {
    private String id;
    private String text;
    private List<String> hastags;
    private List<String> mencions;
    private List<String> paraules_clau;
    private String data_hora;
    private int likes;
    private int retuits;
    private String ubicacio;
    private String sentiment;
    private String usuari_id;

    public Publicacions(){}

    public Publicacions(String id, String text, List<String> hastags, List<String> mencions, List<String> paraules_clau, String data_hora, int likes, int retuits, String ubicacio, String sentiment, String usuari_id) {
        this.id = id;
        this.text = text;
        this.hastags = hastags;
        this.mencions = mencions;
        this.paraules_clau = paraules_clau;
        this.data_hora = data_hora;
        this.likes = likes;
        this.retuits = retuits;
        this.ubicacio = ubicacio;
        this.sentiment = sentiment;
        this.usuari_id = usuari_id;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public List<String> getHastags() {
        return hastags;
    }
    public List<String> getMencions() {
        return mencions;
    }
    public List<String> getParaules_clau() {
        return paraules_clau;
    }
    public String getData_hora() {
        return data_hora;
    }
    public int getLikes() {
        return likes;
    }
    public int getRetuits() {
        return retuits;
    }
    public String getUbicacio() {
        return ubicacio;
    }
    public String getSentiment() {
        return sentiment;
    }
    public String getUsuari_id() {
        return usuari_id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setHastags(List<String> hastags) {
        this.hastags = hastags;
    }
    public void setMencions(List<String> mencions) {
        this.mencions = mencions;
    }
    public void setParaules_clau(List<String> paraules_clau) {
        this.paraules_clau = paraules_clau;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setRetuits(int retuits) {
        this.retuits = retuits;
    }
    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }
    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
    public void setUsuari_id(String usuari_id) {
        this.usuari_id = usuari_id;
    }

    private String toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("text", this.text);
        jsonObject.put("hashtags", this.hastags);
        jsonObject.put("mencions", this.mencions);
        jsonObject.put("paraules_clau", this.paraules_clau);
        jsonObject.put("data_hora", this.data_hora);
        jsonObject.put("likes", this.likes);
        jsonObject.put("retweets", this.retuits);
        jsonObject.put("ubicacio", this.ubicacio);
        jsonObject.put("sentiment", this.sentiment);
        jsonObject.put("usuari_id", this.usuari_id);
        return jsonObject.toString();
    }


}

