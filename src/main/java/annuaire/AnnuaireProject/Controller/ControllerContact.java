package annuaire.AnnuaireProject.Controller;

import annuaire.AnnuaireProject.Model.Contact;
import annuaire.AnnuaireProject.Service.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerContact {
    @Autowired
    private ServiceContact sc;

    // endpoint pour recuperer tt les contacts
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/contacts",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<Contact>> getAllcontacts() {
        List<Contact>  contactsList = sc.recupererContacts();
        return new ResponseEntity<>(contactsList, HttpStatus.OK);
    }
    // endpoint pour recuperer tt les contacts
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/contact/{nom}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<Contact>>  getAllcontactsByName(@PathVariable("nom") String nom) {// Valaeur dans l'url
        return new ResponseEntity<>( sc.recupererContactParNom("%"+nom+"%"), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/contact",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    ResponseEntity<String> ajouterContact (@RequestBody Contact contact) { //Passer un objet
        sc.ajouterContact(contact);
        return new ResponseEntity<>("Contact ajouté avec succès !", HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/contact",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    ResponseEntity<String> deleteContact (@RequestParam long code) {
if (sc.ContactExist(code)){
    sc.supprimerContact(code);
    return new ResponseEntity<>("Contact supprimé avec succès !", HttpStatus.OK);
}else{
    return new ResponseEntity<>("Contact n'existe pas !", HttpStatus.NOT_FOUND);
}
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/contactdel")
    ResponseEntity<String> deleteContactParVille(@RequestParam String ville) {
        for (Contact c : sc.recupererContactParVille(ville)) {
            if (sc.ContactExist(c.getCode())) {
                deleteContact(c.getCode());
            }
        }
        return new ResponseEntity<>("Operation effectuée", HttpStatus.OK);
    }

    public void retirerContactParVille(@RequestParam String ville) {
        sc.supprimerPaVille(ville);
    }
}


