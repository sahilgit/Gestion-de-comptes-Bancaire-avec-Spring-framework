package com.example.demo.dao;

import com.example.demo.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sahil on 11/09/17.
 */
public interface CompteRepository extends JpaRepository<Compte,String> {
}
