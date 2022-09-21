package com.idat.SetiembreIIIE.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.SetiembreIIIE.model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	List<Producto> almacenamiento = new ArrayList<>();

	@Override
	public void save(Producto p) {
		almacenamiento.add(p);
	}

	@Override
	public void update(Producto p) {

		Producto existsUpdate = getId(p.getIdProducto());
		delete(existsUpdate.getIdProducto());
		almacenamiento.add(p);
	}

	@Override
	public void delete(Integer id) {
		Producto existsDelete = getId(id);
		almacenamiento.remove(existsDelete);
	}

	@Override
	public List<Producto> get() {
		// TODO Auto-generated method stub
		return almacenamiento;
	}

	@Override
	public Producto getId(Integer id) {

		// flujos -> solo en listas
		return almacenamiento.stream().filter(p -> p.getIdProducto() == id).findFirst().orElse(null);

	}

}
