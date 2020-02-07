package com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//mechanism to emulate a collection of objects. Encapsulating storage, retrieval, and search behavior
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

}
