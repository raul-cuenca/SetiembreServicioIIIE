package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository almacenamiento;

	@Override
	public void save(Producto p) {
		almacenamiento.save(p);
	}

	@Override
	public void update(Producto p) {
		almacenamiento.saveAndFlush(p);
	}

	@Override
	public void delete(Integer id) {
		almacenamiento.deleteById(id);
	}

	@Override
	public List<Producto> get() {
		return almacenamiento.findAll();
	}

	@Override
	public Producto getId(Integer id) {
		return almacenamiento.findById(id).orElse(null);

	}

}
