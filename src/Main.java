import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-02-26.
 */
public class Main implements Serializable{
    public Map<String, Contact> listeContact = new HashMap<String, Contact>();
    public Contact nouveauContact = new Contact();
    public static void main(String[] args) {

        //new liste

        boolean run = true;
        Scanner sc = new Scanner(System.in);
        int nbContact = 0;
        int choix = 0;
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
                   listeContact.put("1",nouveauContact);
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


    }
    public static void sauvegarder(){
        try {
            ObjectOutputStream enregister = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\treVi1732721\\IdeaProjects\\Liste de Contact\\src\\test.dat")));
            enregister.writeObject(listeContact);
            enregister.close();
        }catch (Exception one){
            System.out.println("Le programme n'a pas été enregistré");
        }
    }
}
