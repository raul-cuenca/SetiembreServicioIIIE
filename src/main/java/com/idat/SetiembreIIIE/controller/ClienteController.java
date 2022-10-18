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

import com.idat.SetiembreIIIE.model.Cliente;
import com.idat.SetiembreIIIE.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(path="/listar",method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> get(){		
		return new ResponseEntity<List<Cliente>>(service.get(),HttpStatus.OK);		
	}
	
	
	@RequestMapping(path="/guardar",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Cliente cliente){
		
		service.save(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path="/listar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> getId(@PathVariable Integer id){
		
		Cliente objCliente = service.getId(id);
		
		if(objCliente != null) {
			return new ResponseEntity<Cliente>(objCliente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/actualizar",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente cliente){
		
		Cliente objCliente = service.getId(cliente.getIdCliente());
		
		if(objCliente != null) {
			service.update(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		Cliente objcliente = service.getId(id);
		
		if(objcliente != null) {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
