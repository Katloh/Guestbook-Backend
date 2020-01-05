package de.applicity.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller // damit wird dem Soring Framework klar gemacht, dass hier HTTP-Requests landen können
//@RequestMapping("/guestbook") // gibt Auskunft über welchen virtuellen Pfad dieser Controller erreichbar ist
public class GuestbookController {

    @Autowired
    private GuestbookRepository repository;

    @RequestMapping(value = "/guestbook", //value = über welchen virtuellen Pfad innerhalb des Guestbook-Controllers diese Methode aufgerufen wird
            // ich: nur wenn hier value = guestbook funktionierts!
            method = RequestMethod.GET, //https-Zugriffsmethode GET = jeder Browser holt sich durch Aufrufen diese Daten
            produces = MediaType.APPLICATION_JSON_VALUE) // mit produces angeben, dass Rückgabe vom Typ JSON ist.
    public ResponseEntity<?> getEntries() { //<?> von einem Beliebigen Typ

        //1. Daten laden
        List<GuestBookEntry> entries = repository.findAllByOrderByIdDesc(); //hier die Methode aus dem Interface aufrufen

        // 2. Daten zurückgeben
        return ResponseEntity.ok(entries);
    }

    // Dies sind klassische REST-FULL Service Methoden

    //Methode um Datensätze anzulegen
    // Parameter ist eine Instanz, die vom Client im Body seiner Anforderung übertragen wird und nicht in der Adresszeile, sondern in dem was der Browser ntzen kann um bspw. Daten hochzuladen, dafür braucht man @RequestBody

    @RequestMapping(value = "/guestbook",
            method = RequestMethod.PUT, // PUT - üblich für Anlage neuer Datensätze
            consumes = MediaType.APPLICATION_JSON_VALUE, // alles was reinkommt hat Typ JSON
            produces = MediaType.APPLICATION_JSON_VALUE) // Rückgabe ist Typ JSON

    public ResponseEntity<?> create(@RequestBody GuestBookEntry entry) {
        //1. Datensatz speichern
        entry = (GuestBookEntry) repository.save(entry); // beim speichern wird autom. Datum gesetzt und der Primärschlüssel festgelegt
        // wenn (GuestBookEntry weg nehme = Fehler...wieso?)
        //2. gespeicherten Datensatz zurückgeben
        return ResponseEntity.ok(entry);
    }
}
