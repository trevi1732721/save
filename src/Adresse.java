import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Adresse implements Serializable{
    private String rue, appartement, ville, province, pays,numCivique;

    public String getNumCivique() {
        return numCivique;
    }

    public void setNumCivique(String numCivique) {
        this.numCivique = numCivique;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAppartement() {
        return appartement;
    }

    public void setAppartement(String appartement) {
        this.appartement = appartement;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void NewAdresse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresse\n");
        System.out.print("  Quel est le numero civic?");
        numCivique = sc.next();
        System.out.print("  Quel est le nom de rue?");
        rue =sc.next();
        System.out.print("  Quel est l'appartement?(Écrire NA si ça ne s'applique pas)");
        appartement=sc.next();
        System.out.print("  Quel est la ville?");
        ville = sc.next();
        System.out.print("  Quel est la province?");
        province = sc.next();
        System.out.print("  Quel est le pays?");
        pays = sc.next();
    }
    public void ModAdresse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresse\n");
        System.out.print("  Quel est le numero civic("+ numCivique +")?");
        if(sc.next().toUpperCase() != "NA") {
            numCivique = sc.next();
        }
        System.out.print("  Quel est le nom de rue("+ rue +")?");
        if(sc.next().toUpperCase() != "NA") {
            rue = sc.next();
        }
        System.out.print("  Quel est l'appartement("+ appartement +")?");
        if(sc.next().toUpperCase() != "NA") {
            appartement = sc.next();
        }
        System.out.print("  Quel est la ville("+ ville +")?");
        if(sc.next().toUpperCase() != "NA") {
            ville = sc.next();
        }
        System.out.print("  Quel est la province("+ province +")?");
        if(sc.next().toUpperCase() != "NA") {
            province = sc.next();
        }
        System.out.print("  Quel est le pays("+ pays +")?");
        if(sc.next().toUpperCase() != "NA") {
            pays = sc.next();
        }
    }
    public void PrintAdresse(){
        System.out.println("    numero civique : "+ numCivique+
        "\n"+ "     rue : "+rue+
        "\n"+ "     appartement : "+appartement+
        "\n"+ "     ville : "+ville+
        "\n"+ "     privince : "+province+
        "\n"+ "     pays : "+ pays);
    }
}
