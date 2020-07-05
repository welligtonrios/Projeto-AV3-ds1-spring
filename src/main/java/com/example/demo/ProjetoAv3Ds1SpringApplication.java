package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Conta;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ContaRepository;

@SpringBootApplication
public class ProjetoAv3Ds1SpringApplication implements CommandLineRunner{
	
	 @Autowired
	 CategoriaRepository categoriaRepository;
	 
	 @Autowired
	 ContaRepository contaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAv3Ds1SpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Conta Poupança");
		Categoria cat2 = new Categoria(null, "Conta Salario");
		Categoria cat3 = new Categoria(null, "Conta Digital");
		
		//aqui as contas conhece sua categoria
		Conta cont1 = new Conta(null,100,200.00,true,cat1); // conta poupança
		Conta cont2 = new Conta(null,200,500.00,true,cat3);//conta digital
		Conta cont3 = new Conta(null,201,500.00,true,cat3);//conta digital
		Conta cont4 = new Conta(null,300,1000.00,true,cat2);//conta Salario
		
		//categoria conhecer suas contas
		cat1.getContas().addAll(Arrays.asList(cont1));
		cat2.getContas().addAll(Arrays.asList(cont4));
		cat3.getContas().addAll(Arrays.asList(cont2,cont3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		contaRepository.saveAll(Arrays.asList(cont1,cont2,cont3,cont4)); // Salvando a conta no banco
		
		
		
	}

}
