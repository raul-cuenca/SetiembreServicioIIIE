package com.idat.SetiembreIIIE.service;

import java.util.List;

import com.idat.SetiembreIIIE.model.Item;

public interface ItemService {

	void save(Item i);

	void update(Item i);

	void delete(Integer id);

	List<Item> get();

	Item getId(Integer id);

}
