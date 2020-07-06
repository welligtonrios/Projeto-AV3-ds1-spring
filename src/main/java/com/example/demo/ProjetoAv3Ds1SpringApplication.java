package com.example.demo;

import java.text.SimpleDateFormat;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Cartão;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Conta;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Faturas;
import com.example.demo.domain.enums.Total;
import com.example.demo.repositories.CartãoRepository;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ContaRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.FaturaRepository;

@SpringBootApplication
public class ProjetoAv3Ds1SpringApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ContaRepository contaRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	CartãoRepository cartãoRepository;
	
	@Autowired
	FaturaRepository faturaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAv3Ds1SpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Criando categoria Conta
		Categoria cat1 = new Categoria(null, "bronze");
		Categoria cat2 = new Categoria(null, "silver");
		Categoria cat3 = new Categoria(null, "gold");

		// aqui as contas conhece sua categoria
		Conta cont1 = new Conta(null, 100, 200.00, true, cat2); // silver
		Conta cont2 = new Conta(null, 200, 500.00, true, cat1);// bronze
		Conta cont3 = new Conta(null, 201, 500.00, true, cat3);// gold
		Conta cont4 = new Conta(null, 300, 1000.00, true, cat3);// silver

		// categoria conhecer suas contas
		cat1.getContas().addAll(Arrays.asList(cont2));
		cat2.getContas().addAll(Arrays.asList(cont1));
		cat3.getContas().addAll(Arrays.asList(cont3, cont4));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		contaRepository.saveAll(Arrays.asList(cont1, cont2, cont3, cont4)); // Salvando a conta no banco

		// cliente
		Cliente cli1 = new Cliente(null, "José", "98584-8584", "jose@jose.com",cont1); // silver
		Cliente cli2 = new Cliente(null, "Maria", "98584-8584", "Maria@Maria.com",cont2); // bronze
		Cliente cli3 = new Cliente(null, "Zé", "98584-8584", "Barto@Barto.com",cont4);// gold

		Endereco ed1 = new Endereco(null, "Rua Delmiro de farias", "125", "Bela Vista", "Fortaleza", "Ce", cli1);
		Endereco ed2 = new Endereco(null, "Rua Papi junior de farias", "250", "Bela Vista", "Fortaleza", "Ce", cli2);
		Endereco ed3 = new Endereco(null, "Rua Br 020", "288", "açudinho", "Campos Belos", "Ce", cli3);
		Endereco ed4 = new Endereco(null, "Rua Frei Marcelino", "122", "Roldolfo", "Fortaleza", "Ce", cli3);

		// lista de enderecos do cliente
		cli1.getEndereco().addAll(Arrays.asList(ed1));
		cli2.getEndereco().addAll(Arrays.asList(ed2));
		cli3.getEndereco().addAll(Arrays.asList(ed3, ed4));

		//
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		//
		enderecoRepository.saveAll(Arrays.asList(ed1, ed2, ed3, ed4));
		
		//Criando cartão
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");
		Cartão cartão1 = new Cartão(null,0000000000000000,sdf.parse("17/06/2027 21:10"),"Zé", 032,"12345", cont4);
		Cartão cartão2 = new Cartão(null,0000000000000000,sdf.parse("17/06/2027 21:10"),"Maria", 032,"12345", cont2);
		Cartão cartão3 = new Cartão(null,0000000000000000,sdf.parse("17/06/2027 21:10"),"José", 032,"12345", cont1);
		
		//Passando o cartão para Conta (conta conhece cartão)
		
		cont1.getCartões().addAll(Arrays.asList(cartão3));
		cont2.getCartões().addAll(Arrays.asList(cartão2));
		cont4.getCartões().addAll(Arrays.asList(cartão1));
		
		cartãoRepository.saveAll(Arrays.asList(cartão1,cartão2,cartão3));
		
		Total total = new Total();
	
		//Criando faturas
		Faturas f1 = new Faturas(null,sdf.parse("30/07/2020 21:10"),sdf.parse("10/08/2020 21:10"),0.0,true,500.00,cartão1);
		Faturas f2 = new Faturas(null,sdf.parse("30/06/2020 21:10"),sdf.parse("10/06/2020 21:10"),0.0,false,500.00,cartão1);
		Faturas f3 = new Faturas(null,sdf.parse("30/05/2020 21:10"),sdf.parse("10/05/2020 21:10"),0.0,false,500.00,cartão1);
		
		Faturas f6 = new Faturas(null,sdf.parse("30/07/2020 21:10"),sdf.parse("10/08/2020 21:10"),0.0,true,500.00,cartão2);
		Faturas f4 = new Faturas(null,sdf.parse("30/06/2020 21:10"),sdf.parse("10/06/2020 21:10"),0.0,false,500.00,cartão2);
		Faturas f5 = new Faturas(null,sdf.parse("30/05/2020 21:10"),sdf.parse("10/05/2020 21:10"),0.0,false,500.00,cartão2);
		
		Faturas f7 = new Faturas(null,sdf.parse("30/07/2020 21:10"),sdf.parse("10/08/2020 21:10"),0.0,true,500.00,cartão3);
		Faturas f8 = new Faturas(null,sdf.parse("30/06/2020 21:10"),sdf.parse("10/06/2020 21:10"),0.0,false,500.00,cartão3);
		Faturas f9 = new Faturas(null,sdf.parse("30/05/2020 21:10"),sdf.parse("10/05/2020 21:10"),0.0,false,500.00,cartão3);
		
		faturaRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9));  
		
		//add faturas ao cartão
		
		cartão1.getFatura().addAll(Arrays.asList(f1,f2,f3));
		cartão2.getFatura().addAll(Arrays.asList(f4,f5,f6));
		cartão3.getFatura().addAll(Arrays.asList(f7,f8,f9));
		
		
		
		
		

	}

}
