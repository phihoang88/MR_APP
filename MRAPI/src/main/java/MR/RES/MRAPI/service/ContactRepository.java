package MR.RES.MRAPI.service;

import MR.RES.MRAPI.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
