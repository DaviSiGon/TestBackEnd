package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Estado;
import com.senai.domain.repositories.EstadoRepository;

@SpringBootTest
public class EstadoTest {
	
	@Autowired
	EstadoRepository estadoRepo;
	
	@Test
	void Estado() {
		Estado est = new Estado();
		est.setId(null);
		est.setNome("Mato Grosso do Sul");
		estadoRepo.save(est);
	}
	
	@Test
	public void listaEstado() {
		List<Estado> list = estadoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idEstado() {
		Estado estado = estadoRepo.findById(1).get();
		assertEquals("Góias", estado.getNome());
	}
	
	@Test
	public void updateEstado() {
		Estado estado = estadoRepo.findById(2).get();
		estado.setNome("Minas Gerais");
		estadoRepo.save(estado);
		assertNotEquals("São Paulo", estado.getNome());
	}
	
	@Test
	public void deleteEstado() {
		estadoRepo.deleteById(2);
		assertThat(estadoRepo.existsById(2));
	}

}
