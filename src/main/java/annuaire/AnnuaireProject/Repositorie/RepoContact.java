package annuaire.AnnuaireProject.Repositorie;

import annuaire.AnnuaireProject.Model.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RepoContact extends CrudRepository<Contact,Long> {
    // findByNom("Ahmed") -> retourner les contacts dpont le nom est exactement Ahmed
    List<Contact> findByNom(String nom);
    // findByNomLike -> retourner tt les contacts dont le nom contient "Ahmed"
    List<Contact> findByNomLike(String nom);
    List<Contact> findByAdresseLike(String adresse);

    @Modifying
    @Transactional
    @Query("DELETE FROM Contact WHERE UPPER(adresse)  LIKE UPPER(:ville)")
    void supprimerParVille(@Param("ville") String ville);
}
