package com.idat.SetiembreIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	private ProductoService repository;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> get() {

		return new ResponseEntity<List<Producto>>(repository.get(), HttpStatus.OK);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Producto producto) {

		repository.save(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> getId(@PathVariable Integer id) {

		Producto producto = repository.getId(id);
		if (producto != null) {
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Producto producto) {

		Producto objProducto = repository.getId(producto.getIdProducto());

		if (objProducto != null) {
			repository.update(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		Producto objProducto = repository.getId(id);
		if (objProducto != null) {
			repository.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
