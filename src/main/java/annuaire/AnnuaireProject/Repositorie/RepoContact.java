package annuaire.AnnuaireProject.Repositorie;

import annuaire.AnnuaireProject.Model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoContact extends CrudRepository<Contact,Long> {
    // findByNom("Ahmed") -> retourner les contacts dpont le nom est exactement Ahmed
    List<Contact> findByNom(String nom);
    // findByNomLike -> retourner tt les contacts dont le nom contient "Ahmed"
    List<Contact> findByNomLike(String nom);

}
