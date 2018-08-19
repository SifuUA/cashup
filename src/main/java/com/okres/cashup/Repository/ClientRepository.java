package com.okres.cashup.Repository;

import com.okres.cashup.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides sophisticated CRUD functionality for the entity class that is being managed.
 */

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findById(long id);
}