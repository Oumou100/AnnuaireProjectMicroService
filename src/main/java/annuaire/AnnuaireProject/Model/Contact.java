package annuaire.AnnuaireProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {
    @Id
    private long code;
    private String nom;
    private String telephone;
    private String adresse;

    public Contact() {
    }
    public Contact(int code, String nom, String telephone, String adresse) {
        this.code = code;
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
    }
    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}

