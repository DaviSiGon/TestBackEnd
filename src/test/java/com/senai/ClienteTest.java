package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cliente;
import com.senai.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("José Carlo Franca");
		cli.setCpfOuCnpj("12312312312");
		cli.setEmail("zefranca@gmail.com");
		clienteRepo.save(cli);
	}
	
	@Test
	public void listaCliente() {
		List<Cliente> list = clienteRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		assertEquals("Lui Lucca", cliente.getNome());
	}
	
	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepo.findById(2).get();
		cliente.setNome("Zé França");
		clienteRepo.save(cliente);
		assertNotEquals("El Craco", cliente.getNome());
	}
	
	@Test
	public void deleteClinte() {
		clienteRepo.deleteById(2);
		assertThat(clienteRepo.existsById(2));
	}
	
	
	//Teste das Operações Matemáticas 
	@Test
	public void somar() {
		double num1 = 2;
		double num2 = 7;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(9, soma);
	}
	
	@Test
	public void subtrair() {
		double num1 = 15;
		double num2 = 5;
		Cliente cliente = new Cliente();
		double subtracao = cliente.subtrair(num1, num2);
		assertEquals(10, subtracao);
	}
	
	@Test
	public void multiplicar() {
		double num1 = 9;
		double num2 = 9;
		Cliente cliente = new Cliente();
		double multiplicacao = cliente.multiplicar(num1, num2);
		assertEquals(81, multiplicacao);
	}
	
	@Test
	public void dividir() {
		double num1 = 10;
		double num2 = 2;
		Cliente cliente = new Cliente();
		double divisao = cliente.dividir(num1, num2);
		assertEquals(5, divisao);
	}

}
