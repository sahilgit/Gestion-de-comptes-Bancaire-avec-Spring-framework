package com.example.demo.dao;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

/**
 * Created by sahil on 11/09/17.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {


}
