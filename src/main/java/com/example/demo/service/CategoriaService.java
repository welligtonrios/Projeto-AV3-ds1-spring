package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	
	public Categoria find(Integer id) {
		
		//chamando metodo para recuperar o id
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElse(null);
	}
	
	
	
	
}
