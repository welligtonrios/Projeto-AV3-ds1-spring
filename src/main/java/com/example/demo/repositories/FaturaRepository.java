package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Faturas;

public interface FaturaRepository extends JpaRepository<Faturas, Integer>{

}
