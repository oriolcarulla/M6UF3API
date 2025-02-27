package View;

import Model.Publicacions;

public class View {
    private String separador ="----------------------------------------";
    public View(){}
    public void load(){System.out.println("Loading...");}
    public void goodbye(){System.out.println("Goodbye!");}
    public void showMainMenu(){
        System.out.println(separador);
        System.out.println("1. Llistar totes les publicacions");
        System.out.println("2. Crear una nova publicacio");
        System.out.println("3. Filtrar per dates");
        System.out.println("4. Exit");
        System.out.println(separador);
    }

    public void printPublicacio(Publicacions p){
        System.out.println(separador);
        System.out.println("ID: " + p.getId());
        System.out.println("Text: " + p.getText());
        System.out.println("Hashtags: " + p.getHastags());
        System.out.println("Mencions: " + p.getMencions());
        System.out.println("Paraules clau: " + p.getParaules_clau());
        System.out.println("Data i hora: " + p.getData_hora());
        System.out.println("Likes: " + p.getLikes());
        System.out.println("Retuits: " + p.getRetuits());
        System.out.println("Ubicacio: " + p.getUbicacio());
        System.out.println("Sentiment: " + p.getSentiment());
        System.out.println("Usuari ID: " + p.getUsuari_id());
        System.out.println(separador);
    }

    public void inputPublicacio(){
        System.out.println(separador);
        System.out.println("Introdueix el text de la publicacio: ");
    }

    public void inputHashtags() {
        System.out.println("Introdueix un hashtag (exit): ");
    }

    public void inputFecha1() {
        System.out.println("Introdueix la data de la publicacio desde (yyyy-MM-dd): ");
    }
    public void inputFecha2() {
        System.out.println("Introdueix la data de la publicacio hasta (yyyy-MM-dd): ");
    }
}
