package com.idat.SetiembreIIIE.repository;

import java.util.List;

import com.idat.SetiembreIIIE.model.Producto;

public interface ProductoRepository {
	
	void save(Producto p);
	void update(Producto p);
	void delete(Integer id);
	List<Producto> get();
	Producto getId(Integer id);
	
	

}
