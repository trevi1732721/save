import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Entreprise implements Serializable {
    private String nom ;
    private Adresse adresseEntreprise = new Adresse() ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public void setAdresseEntreprise(Adresse adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    public void NewEntreprise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("L'entreprise");
        System.out.print("  Quel est le nom de l'entreprise?");
        nom = sc.next();
        adresseEntreprise.NewAdresse();

    }
    public void ModEntreprise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("L'entreprise");
        System.out.print("  Quel est le nom de l'entreprise("+nom+")?");
        if(sc.next().toUpperCase() != "NA") {
            nom = sc.next();
        }
        adresseEntreprise.ModAdresse();

    }
    public void PrintEntreprise(){
        System.out.println("Entreprise" +
                "\n     "+ nom);
        adresseEntreprise.PrintAdresse();
    }

}
