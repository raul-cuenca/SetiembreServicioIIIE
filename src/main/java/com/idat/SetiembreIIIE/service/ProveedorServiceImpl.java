package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Proveedor;
import com.idat.SetiembreIIIE.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	ProveedorRepository repositorio;
	
	@Override
	public void save(Proveedor p) {
		repositorio.save(p);
	}

	@Override
	public void update(Proveedor p) {
		repositorio.saveAndFlush(p);
	}

	@Override
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Proveedor> get() {
		return repositorio.findAll();
	}

	@Override
	public Proveedor getId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
