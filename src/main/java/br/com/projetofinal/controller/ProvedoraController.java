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

import br.com.projetofinal.beans.Provedora;
import br.com.projetofinal.dao.ProvedoraDAO;

@RestController
@CrossOrigin("*")
public class ProvedoraController {

	@Autowired
	private ProvedoraDAO dao;
	
	@GetMapping("/provedora")
	public ResponseEntity<List<Provedora>> listarProvedoras(){
		List<Provedora> coll = (List<Provedora>)dao.findAll();
		
		if(coll.size() == 0 ) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(coll);
		
	}
	
	@GetMapping("/provedora/{codigo}")
	public ResponseEntity<Provedora> obterProvedora(@PathVariable int codigo) {
		
		Provedora result = dao.findById(codigo).orElse(null);
		
		if(result == null) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/provedora")
	public ResponseEntity<Provedora> criarProvedora(@RequestBody Provedora provedora) {
		try {
			dao.save(provedora);
			return ResponseEntity.ok(provedora);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
}
