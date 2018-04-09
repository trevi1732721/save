import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by TreVi1732721 on 2018-01-22.
 */
public class Telephone implements Serializable {
    private String information, numero;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void NewTelephone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est le type de numero de téléphone?");
        information = sc.next();
        System.out.println("Quel est le numero de téléphone?");
        numero = sc.next();
    }
}
