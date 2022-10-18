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

import com.idat.SetiembreIIIE.model.Item;
import com.idat.SetiembreIIIE.service.ItemService;

@RestController
@RequestMapping("/item/v1")
public class ItemController {

	@Autowired
	private ItemService service;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> get() {
		
		return new ResponseEntity<List<Item>>(service.get(), HttpStatus.OK);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Item item) {

		service.save(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> getId(@PathVariable Integer id) {

		Item objItem = service.getId(id);

		if (objItem != null) {
			return new ResponseEntity<Item>(objItem, HttpStatus.OK);
		} else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Item item) {

		Item objItem = service.getId(item.getIdItem());

		if (objItem != null) {
			service.save(item);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		Item objItem = service.getId(id);

		if (objItem != null) {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
