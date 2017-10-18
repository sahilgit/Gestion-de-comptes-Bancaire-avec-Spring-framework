package com.example.demo;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entities.*;
import com.example.demo.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier iBanqueMetier;

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {







	}

}
