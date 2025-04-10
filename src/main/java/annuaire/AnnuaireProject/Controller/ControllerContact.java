package annuaire.AnnuaireProject.Controller;

import annuaire.AnnuaireProject.Model.Contact;
import annuaire.AnnuaireProject.Service.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    List<Contact> getAllcontacts() {
        return sc.recupererContacts();
    }

    // endpoint pour recuperer tt les contacts
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/contact/{nom}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<Contact> getAllcontactsByName(@PathVariable("nom") String nom) {
        return sc.recupererContactParNom("%"+nom+"%");
    }
}


