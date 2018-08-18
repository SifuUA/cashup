package com.okres.cashup.Repository;

import com.okres.cashup.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findById (long id);
}
