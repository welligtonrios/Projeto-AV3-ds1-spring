package com.example.demo.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.service.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	
	public Cliente find(Integer id) {
		
		//chamando metodo para recuperar o id do cliente 
		Optional<Cliente> obj = repository.findById(id);
		//quando nao existir o que eu procuro eu retorno o orElseThrow com o Objeto ObjectNotFoundException criado
		return obj.orElseThrow((()-> new ObjectNotFoundException(
				"Objeto não encontrado!  ID: " + id + "Tipo: " + Cliente.class.getName())));
	}
	
	
	
	
}
