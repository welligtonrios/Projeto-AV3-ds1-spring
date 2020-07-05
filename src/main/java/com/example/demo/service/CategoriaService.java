package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.service.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	
	public Categoria find(Integer id) {
		
		//chamando metodo para recuperar o id
		Optional<Categoria> obj = repository.findById(id);
		//quando nao existir o que eu procuro eu retorno o orElseThrow com o Objeto ObjectNotFoundException criado
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Objeto nao encontado! ID: " + id + " , Tipo: " + Categoria.class.getName()));
	}
	
	
	
	
}
