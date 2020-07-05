package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
