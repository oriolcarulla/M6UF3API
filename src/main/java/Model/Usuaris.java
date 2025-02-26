package Model;

import org.json.JSONObject;

public class Usuaris {
    private String id;
    private String nom_usuari;
    private long seguidors;
    private boolean verificat;

    public Usuaris(){}

    public Usuaris(String id, String nom_usuari, long seguidors, boolean verificat) {
        this.id = id;
        this.nom_usuari = nom_usuari;
        this.seguidors = seguidors;
        this.verificat = verificat;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }
    public String getNom_usuaris() {
        return nom_usuari;
    }
    public long getSeguidors() {
        return seguidors;
    }
    public boolean isVerificat() {
        return verificat;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setNom_usuaris(String nom_usuari) {
        this.nom_usuari = nom_usuari;
    }
    public void setSeguidors(long seguidors) {
        this.seguidors = seguidors;
    }
    public void setVerificat(boolean verificat) {
        this.verificat = verificat;
    }

    private String toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("nom_usuari", this.nom_usuari);
        jsonObject.put("seguidors", this.seguidors);
        jsonObject.put("verificat", this.verificat);
        return jsonObject.toString();
    }
}
