import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Occupation implements Serializable{
    private String poste;
    private Entreprise entreprise = new Entreprise();

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public void NewOccupation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("  Quel est l'emplois du contact?");
        poste = sc.next();
        entreprise.NewEntreprise();
    }
    public void ModOccupation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("  Quel est l'emplois du contact("+poste+")?");
        if(sc.next().toUpperCase() != "NA") {
            poste = sc.next();
        }
        entreprise.ModEntreprise();
    }
    public void PrintOccupation(){
        System.out.println("    poste : "+ poste);
        entreprise.PrintEntreprise();
    }
}
