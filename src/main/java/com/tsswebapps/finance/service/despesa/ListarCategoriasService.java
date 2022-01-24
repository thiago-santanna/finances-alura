package com.tsswebapps.finance.service.despesa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tsswebapps.finance.model.Categoria;

@Service
public class ListarCategoriasService {

	private Categoria[] categoriasEnum = Categoria.values();
	
	public List<String> execute(){
		List<String> categorias = new ArrayList<String>();
		for (Categoria cat : categoriasEnum) {
			categorias.add(cat.toString());
		}
		return categorias;
	}
}
