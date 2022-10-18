package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Cliente;
import com.idat.SetiembreIIIE.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository repositorio; 
	
	@Override
	public void save(Cliente c) {
		repositorio.save(c);
	}

	@Override
	public void update(Cliente c) {
		repositorio.saveAndFlush(c);
	}

	@Override
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Cliente> get() {
		return repositorio.findAll();
	}

	@Override
	public Cliente getId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
