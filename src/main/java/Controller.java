
import DAO.PublicacionsDAO;
import Model.Publicacions;
import View.View;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        PublicacionsDAO publicacionsDAO = new PublicacionsDAO();
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        View view = new View();
        boolean exit = false;
        while(!exit){
            view.showMainMenu();
            int option = checkInput(input, 1, 4);
            switch (option){
                case 1:
                    view.load();
                    try {
                        ArrayList<Publicacions> publicacions = publicacionsDAO.listarPublicacions().get();
                        for (Publicacions p : publicacions){
                            view.printPublicacio(p);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // Limpiar el buffer antes de leer una línea completa
                    input.nextLine();
                    // Limpiar el buffer antes de leer una línea completa
                    String fechaActual = Instant.now()
                            .atOffset(ZoneOffset.UTC)
                            .truncatedTo(java.time.temporal.ChronoUnit.SECONDS) // Elimina los nanosegundos
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")); // Formato deseado
                    ArrayList<String> hashtags = new ArrayList<>();
                    ArrayList<String> mencions = new ArrayList<>();
                    ArrayList<String> paraules_clau = new ArrayList<>();
                    Publicacions p = new Publicacions("0", "label", hashtags, mencions, paraules_clau, fechaActual, 0, 0, "label", "label", "0");
                    //ID
                    int id = publicacionsDAO.getLastId();
                    id++;
                    p.setId(String.valueOf(id));
                    //Text
                    view.inputPublicacio();
                    String text = input.nextLine();
                    p.setText(text);
                    //Hashtags
                    while(true){
                        view.inputHashtags();
                        String hashtag = input.nextLine();
                        if (hashtag.equals("exit")){
                            break;
                        }
                        hashtags.add(hashtag);
                    }
                    p.setHastags(hashtags);
                    System.out.println("Hashtags antes de enviar: " + p.getHastags());
                    //Fecha
                    p.setData_hora(fechaActual);
                    publicacionsDAO.enviarPublicacio(p);
                    break;
                case 3:
                    // Limpiar el buffer antes de leer una línea completa
                    input.nextLine();

                    view.inputFecha1();
                    String fechaInicioBorrador = input.nextLine();
                    String fechaInicio = fechaInicioBorrador + "T00:00:00Z";
                    view.inputFecha2();
                    String fechaFinBorrador = input.nextLine();
                    String fechaFin = fechaFinBorrador + "T23:59:59Z";

                    try {
                        ArrayList<Publicacions> publicacions = publicacionsDAO.listarPublicacions().get();

                        for (Publicacions pub : publicacions){
                            if (pub.getData_hora().compareTo(fechaInicio) >= 0 && pub.getData_hora().compareTo(fechaFin) <= 0){
                                view.printPublicacio(pub);
                            }
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    view.goodbye();
                    exit = true;
                    break;
            }
        }

    }

    private static int checkInput(Scanner input, int min, int max){
        int option = 0;
        boolean valid = false;
        while (!valid){
            System.out.print("Enter an option: ");
            if (input.hasNextInt()){
                option = input.nextInt();
                if (option >= min && option <= max){
                    valid = true;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }else{
                System.out.println("Invalid option. Please try again.");
                input.next();
            }
        }
        return option;

    }
}