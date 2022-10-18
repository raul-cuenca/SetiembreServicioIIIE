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

import com.idat.SetiembreIIIE.model.Proveedor;
import com.idat.SetiembreIIIE.service.ProveedorService;

@RestController
@RequestMapping("/proveedor/v1")
public class ProveedorController {
	
	@Autowired
	private ProveedorService service;
	
	@RequestMapping(path = "/listar",method = RequestMethod.GET)
	public ResponseEntity<List<Proveedor>> get(){
		return new ResponseEntity<List<Proveedor>>(service.get(), HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/guardar",method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Proveedor proveedor){
		service.save(proveedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/listar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Proveedor> getId(@PathVariable Integer id){
		
		Proveedor proveedor = service.getId(id);
		if(proveedor != null) {
			return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
		}else {
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(path="/actualizar",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Proveedor proveedor){
		
		Proveedor objProveedor = service.getId(proveedor.getIdProveedor());
		
		if(objProveedor != null) {
			service.update(proveedor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(path="/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		Proveedor objProveedor = service.getId(id);
		
		if(objProveedor != null) {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
