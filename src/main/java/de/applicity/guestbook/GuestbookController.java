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

@Controller
public class GuestbookController {

    @Autowired
    private GuestbookRepository repository;

    @RequestMapping(value = "/guestbook",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEntries() {

        List<GuestBookEntry> entries = repository.findAllByOrderByIdDesc();
        return ResponseEntity.ok(entries);
    }

    @RequestMapping(value = "/guestbook",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> create(@RequestBody GuestBookEntry entry) {

        entry = (GuestBookEntry) repository.save(entry);
        return ResponseEntity.ok(entry);
    }
}
