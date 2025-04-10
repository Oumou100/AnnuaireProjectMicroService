package annuaire.AnnuaireProject.Service;

import annuaire.AnnuaireProject.Model.Contact;
import annuaire.AnnuaireProject.Repositorie.RepoContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceContact {
    @Autowired
    private RepoContact r;
    public void ajouterContact(Contact c){
        r.save(c);
    }
    public List<Contact> recupererContacts(){
        return (List<Contact>)r.findAll();
    }
    public List<Contact> recupererContactParNom(String nom){
        return (List<Contact>) r.findByNomLike(nom);
    }
}