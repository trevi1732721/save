import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-02-26.
 */
public class Main implements Serializable{

    public static class WrongTypeExeption extends Exception{}

    protected static HashMap<String, Contact> listeContact = new HashMap<String, Contact>();
    protected static Contact nouveauContact = new Contact();
    public static void main(String[] args) {

        //new liste

        boolean run = true, exeption = true;
        Scanner sc = new Scanner(System.in);
        String choix = "0";

       while(run){
            exeption = true;
           System.out.println("Que voulez vous faire?" +
                   "\n1- Nouveau contact" +
                   "\n2- Afficher les contacts" +
                   "\n3- Modifier et ajouter un numero de téléphone" +
                   "\n4- Modifier un contact" +
                   "\n5- Effacer un contact" +
                   "\n6- Charger la liste");

           switch(sc.nextInt()) {
               case 1:
                   nouveauContact.NewContact();
                   listeContact.put(nouveauContact.getPrenom(), nouveauContact);
                   break;
               case 2:
                   System.out.println("Quel est le contact à afficher?");
                   try {
                       choix = sc.next();
                       for (int i = 0; i < choix.length(); i++) {
                           if ((int) choix.toUpperCase().charAt(i) > 90 && (int) choix.toUpperCase().charAt(i) < 65) {
                               throw new WrongTypeExeption();
                           }
                       }


                       System.out.println("___________________________________");
                       System.out.println("Contact " + choix);
                       listeContact.get(choix).PrintContact();
                       System.out.println("\n___________________________________");
                   } catch (WrongTypeExeption one) {
                       System.out.print("Entrée selement des lettres svp.");
                   }
                   break;
               case 3:
                   System.out.println("Que voulez vous faire?" +
                           "\n 1- modifier un numero" +
                           "\n 2- ajouter un numero");
                   try{
                   choix = sc.next();
                   if(choix=="1"){
                       System.out.println("modifier quel contact?");
                       choix = sc.next();
                       listeContact.get(choix).ModTelephone();
                   }else if(choix=="2"){
                       System.out.println("Ajouter un numero a quel contact?");
                       choix = sc.next();
                       listeContact.get(choix).NewTelephone();
                   }else {
                       System.out.println("Selection invalide, veuiller faire un choix valide.");
                   }}catch(Exception one){
                       System.out.print("vous devez entrée une selection valide!");
                   }
                   break;
               case 4:
                   System.out.println("Quel est le contact à modifier?");
                   choix = sc.next();
                   listeContact.get(choix).ModContact();
                   break;
               case 5:
                   System.out.print("Quel est le contact à effacer?");
                   choix = sc.next();
                   listeContact.remove(choix);
                   break;
               case 6:
                   Charger();
               default:
           }
               Sauvegarder();
               System.out.print("voulez vous continuer la liste de contacts?" +
                       "\n  1- oui" +
                       "\n  2- non \n");
               if (sc.nextInt() == 2){
                   run = false;
               }

       }
       }



    }
    public static void Sauvegarder(){
        try {
            ObjectOutputStream sortieListe = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("test.dat")));
            sortieListe.writeObject(listeContact);
            sortieListe.close();
            System.out.println("Le programme a été enregistré !");
        }catch (Exception two){
            System.out.println("Le programme n'a pas été enregistré");
        }
    }
    public static void Charger(){
        try{
            ObjectInputStream entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream("test.dat")));
            listeContact = (HashMap<String, Contact>) entree.readObject();
            entree.close();
            System.out.println("Le programme a été charger !");
        }catch(Exception one){
            System.out.println("Le programme n'a pas trouvé d'enregistrement");
        }
    }
}
