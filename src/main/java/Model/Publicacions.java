package Model;

import org.json.JSONObject;

import java.util.ArrayList;

public class Publicacions {
    private String id;
    private String text;
    private ArrayList<String> hashtags;
    private ArrayList<String> mencions;
    private ArrayList<String> paraules_clau;
    private String data_hora;
    private Long likes;
    private Long retweets;
    private String ubicacio;
    private String sentiment;
    private String usuari_id;

    public Publicacions(){}

    public Publicacions(String id, String text, ArrayList<String> hashtags, ArrayList<String> mencions, ArrayList<String> paraules_clau, String data_hora, Long likes, Long retweets, String ubicacio, String sentiment, String usuari_id) {
        this.id = id;
        this.text = text;
        this.hashtags = hashtags;
        this.mencions = mencions;
        this.paraules_clau = paraules_clau;
        this.data_hora = data_hora;
        this.likes = likes;
        this.retweets = retweets;
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
    public ArrayList<String> getHashtags() {
        return hashtags;
    }
    public ArrayList<String> getMencions() {
        return mencions;
    }
    public ArrayList<String> getParaules_clau() {
        return paraules_clau;
    }
    public String getData_hora() {
        return data_hora;
    }
    public Long getLikes() {
        return likes;
    }
    public Long getRetweets() {
        return retweets;
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
    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }
    public void setMencions(ArrayList<String> mencions) {
        this.mencions = mencions;
    }
    public void setParaules_clau(ArrayList<String> paraules_clau) {
        this.paraules_clau = paraules_clau;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
    public void setLikes(Long likes) {
        this.likes = likes;
    }
    public void setRetweets(Long retweets) {
        this.retweets = retweets;
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
        jsonObject.put("hashtags", this.hashtags);
        jsonObject.put("mencions", this.mencions);
        jsonObject.put("paraules_clau", this.paraules_clau);
        jsonObject.put("data_hora", this.data_hora);
        jsonObject.put("likes", this.likes);
        jsonObject.put("retweets", this.retweets);
        jsonObject.put("ubicacio", this.ubicacio);
        jsonObject.put("sentiment", this.sentiment);
        jsonObject.put("usuari_id", this.usuari_id);
        return jsonObject.toString();
    }


}

