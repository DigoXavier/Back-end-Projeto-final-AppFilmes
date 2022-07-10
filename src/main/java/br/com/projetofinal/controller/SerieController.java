package br.com.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.beans.Serie;
import br.com.projetofinal.dao.SerieDAO;

@RestController
@CrossOrigin("*")
public class SerieController {

	@Autowired
	private SerieDAO dao;
	
	@GetMapping("/serie")
	public ResponseEntity<List<Serie>> listarSeries(){
		List<Serie> coll = (List<Serie>)dao.findAll();
		
		if(coll.size() == 0 ) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(coll);
		
	}
	
	@GetMapping("/serie/{codigo}")
	public ResponseEntity<Serie> obterSerie(@PathVariable int codigo) {
		
		Serie result = dao.findById(codigo).orElse(null);
		
		if(result == null) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/serie")
	public ResponseEntity<Serie> criarSerie(@RequestBody Serie serie) {
		try {
			dao.save(serie);
			return ResponseEntity.ok(serie);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
}

