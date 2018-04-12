import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-02-26.
 */
public class Main implements Serializable{
    public static HashMap<String, Contact> listeContact = new HashMap<String, Contact>();
    public static Contact nouveauContact = new Contact();
    public static void main(String[] args) {

        //new liste

        boolean run = true;
        Scanner sc = new Scanner(System.in);
        int nbContact = 0;
        int choix = 0;

        Charger();
       while(run){

           System.out.println("Que voulez vous faire?" +
                   "\n1- Nouveau contact" +
                   "\n2- Afficher les contacts" +
                   "\n3- Modifier et ajouter un numero de téléphone" +
                   "\n4- Modifier un contact" +
                   "\n5- effacer un contact");
           switch(sc.nextInt()){
               case 1:
                   nouveauContact.NewContact();
                   listeContact.put(nouveauContact.getPrenom(),nouveauContact);
                   nbContact++;
                   break;
               case 2:
                   for (int i=1; i<=nbContact; i++) {
                       System.out.println("___________________________________");
                       System.out.println("Contact "+ i );
                       listeContact.get(i).PrintContact();
                       System.out.println("\n___________________________________");
                   }

                   break;
               case 3:
                   System.out.println("Que voulez vous faire?" +
                           "\n 1- modifier un numero" +
                           "\n 2- ajouter un numero");
                   choix = sc.nextInt();
                   if(choix==1){
                       System.out.println("modifier quel numero de contact?");
                       choix = sc.nextInt();
                       listeContact.get(choix).ModTelephone();
                   }else if(choix==2){
                       System.out.println("Ajouter un numero a quel contact?");
                       choix = sc.nextInt();
                       listeContact.get(choix).NewTelephone();
                   }
                   break;
               case 4:
                   System.out.println("Quel est le numero du contact à modifier?");
                   choix = sc.nextInt();
                   listeContact.get(choix).ModContact();
                   break;
               case 5:
                   System.out.print("Quel est le contact à effacer?");
                   choix = sc.nextInt();
                   listeContact.remove(choix);
                   break;
               default:
                   break;
           }
           System.out.print("voulez vous continuer la liste de contacts?" +
                   "\n  1- oui" +
                   "\n  2- non\n");
           choix = sc.nextInt();
           if (choix ==  2){
               run = false;
           }
       }
        Sauvegarder();


    }
    public static void Sauvegarder(){
        try {
            ObjectOutputStream sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("test.dat")));
            sortie.writeObject(listeContact);
            sortie.close();
        }catch (Exception two){
            System.out.println("Le programme n'a pas été enregistré");
        }
    }
    public static void Charger(){
        try{
            ObjectInputStream entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream("test.dat")));
            listeContact = (HashMap<String, Contact>) entree.readObject();
            entree.close();
        }catch(Exception one){
            System.out.println("Le programme n'a pas trouvé d'enregistrement");
        }
    }
}
