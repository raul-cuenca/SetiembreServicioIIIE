package com.idat.SetiembreIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Item;
import com.idat.SetiembreIIIE.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository repositorio;

	@Override
	public void save(Item i) {
		repositorio.save(i);
	}

	@Override
	public void update(Item i) {
		repositorio.saveAndFlush(i);
	}

	@Override
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Item> get() {
		return repositorio.findAll();
	}

	@Override
	public Item getId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	
	
}
