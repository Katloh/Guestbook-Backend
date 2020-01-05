package de.applicity.guestbook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestbookRepository extends JpaRepository<GuestBookEntry, Long> { //in <> ist ein Generics

    public List<GuestBookEntry> findAllByOrderByIdDesc();//die List ist vom Typ GuestbookEntry
                                    //Sprng Data anaylisiert diesen MethodenNamen

}
