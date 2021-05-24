package com.meters.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meters.apirest.models.Meters;
import com.meters.apirest.repository.MetersRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Meters")
@CrossOrigin(origins = "*")
public class MetersResource {

	@Autowired
	MetersRepository metersRepository;

	@ApiOperation(value = "Retorna uma lista de medidores")
	@GetMapping("/meters")
	public List<Meters> listaMeters() {
		return metersRepository.findAll();
	}

	@ApiOperation(value = "Retorna um unico medidor")
	@GetMapping("/meters/{id}")
	public Meters listaMetersUnico(@PathVariable(value = "id") int id) {
		return metersRepository.findById(id);
	}

	@ApiOperation(value = "Salva um medidor")
	@PostMapping("/meters")
	public Meters salvaMeters(@RequestBody Meters meters) {
		return metersRepository.save(meters);
	}
	
	@ApiOperation(value = "Deleta um medidor")
	@DeleteMapping("/meters")
	public void deleteMeters(@RequestBody Meters meters) {
		metersRepository.delete(meters);
	}

	@ApiOperation(value = "Atualiza um medidor")
	@PutMapping("/meters")
	public Meters atualizaMeters(@RequestBody Meters meters) {
		return metersRepository.save(meters);
	}
}
