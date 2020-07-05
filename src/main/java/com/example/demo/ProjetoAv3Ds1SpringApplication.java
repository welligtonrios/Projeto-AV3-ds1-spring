package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Conta;
import com.example.demo.domain.Endereco;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ContaRepository;
import com.example.demo.repositories.EnderecoRepository;

@SpringBootApplication
public class ProjetoAv3Ds1SpringApplication implements CommandLineRunner{
	
	 @Autowired
	 CategoriaRepository categoriaRepository;
	 
	 @Autowired
	 ContaRepository contaRepository;
	 
	 @Autowired
	 ClienteRepository clienteRepository;
	 
	 @Autowired
	 EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAv3Ds1SpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "bronze");
		Categoria cat2 = new Categoria(null, "silver");
		Categoria cat3 = new Categoria(null, "gold");
		
		//aqui as contas conhece sua categoria
		Conta cont1 = new Conta(null,100,200.00,true,cat2); // silver
		Conta cont2 = new Conta(null,200,500.00,true,cat1);//bronze
		Conta cont3 = new Conta(null,201,500.00,true,cat3);//gold
		Conta cont4 = new Conta(null,300,1000.00,true,cat2);//silver
		
		//categoria conhecer suas contas
		cat1.getContas().addAll(Arrays.asList(cont1));
		cat2.getContas().addAll(Arrays.asList(cont4));
		cat3.getContas().addAll(Arrays.asList(cont2,cont3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		contaRepository.saveAll(Arrays.asList(cont1,cont2,cont3,cont4)); // Salvando a conta no banco
		
		//cliente
		Cliente cli1 = new Cliente(null, "José", "98584-8584", "jose@jose.com"); //silver
		Cliente cli2 = new Cliente(null, "Maria", "98584-8584", "Maria@Maria.com"); //bronze
		Cliente cli3 = new Cliente(null, "Barto", "98584-8584", "Barto@Barto.com");//gold
		
		Endereco ed1 = new Endereco(null,"Rua Delmiro de farias","125","Bela Vista","Fortaleza","Ce",cli1);
		Endereco ed2 = new Endereco(null,"Rua Papi junior de farias","250","Bela Vista","Fortaleza","Ce",cli2);
		Endereco ed3 = new Endereco(null,"Rua Br 020","288","açudinho","Campos Belos","Ce",cli3);
		Endereco ed4 = new Endereco(null,"Rua Frei Marcelino","122","Roldolfo","Fortaleza","Ce",cli3);
		
		//lista de enderecos do cliente
		cli1.getEndereco().addAll(Arrays.asList(ed1));
		cli2.getEndereco().addAll(Arrays.asList(ed2));
		cli3.getEndereco().addAll(Arrays.asList(ed3,ed4));
		
		//
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
		//
		enderecoRepository.saveAll(Arrays.asList(ed1,ed2,ed3,ed4));
		
	}

}
