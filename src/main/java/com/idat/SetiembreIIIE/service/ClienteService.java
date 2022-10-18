package com.idat.SetiembreIIIE.service;

import java.util.List;

import com.idat.SetiembreIIIE.model.Cliente;

public interface ClienteService {

	void save(Cliente c);

	void update(Cliente c);

	void delete(Integer id);

	List<Cliente> get();

	Cliente getId(Integer id);
}
