package com.meters.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meters.apirest.models.Meters;

public interface MetersRepository extends JpaRepository<Meters, Long> {

	Meters findById(int id);
}
