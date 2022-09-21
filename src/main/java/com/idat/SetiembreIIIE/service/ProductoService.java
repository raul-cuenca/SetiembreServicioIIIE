package com.idat.SetiembreIIIE.service;

import java.util.List;

import com.idat.SetiembreIIIE.model.Producto;

public interface ProductoService {

	void save(Producto p);

	void update(Producto p);

	void delete(Integer id);

	List<Producto> get();

	Producto getId(Integer id);

}
