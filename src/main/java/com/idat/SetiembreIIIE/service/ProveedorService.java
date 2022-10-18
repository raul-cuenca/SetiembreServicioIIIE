package com.idat.SetiembreIIIE.service;

import java.util.List;

import com.idat.SetiembreIIIE.model.Proveedor;

public interface ProveedorService {

	void save(Proveedor p);

	void update(Proveedor p);

	void delete(Integer id);

	List<Proveedor> get();

	Proveedor getId(Integer id);
}
