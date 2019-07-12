package com.wiliam.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.repositories.CategoriaRepository;
import com.wiliam.cursomc.services.exceptions.ObjectNotFoundException;

// anotacao responsavel por dizer ao spring que esta classe eh uma classe de servico
@Service
public class CategoriaService {
	
	// anotacao responsavel por atribuir ao spring a responsabilidade de injetar esta dependencia
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		// o metodo 'findById()' eh responsavel por buscar  um elemento por id e retornarnar um Optional
		Optional<Categoria> obj = repo.findById(id);
		
		// o metodo .orElseThrow() retorna um objeto e,m caso este seja null, lanca a excecao definida
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id:" 
		+ Categoria.class.getName()
		));
	}
	
	// metodo reponsável por inserir uma nova Categoria
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		// o metodo 'save' insere um novo registro quando o id == null
		return repo.save(obj);
	}

	// metodo responsável por atualizar o registro
	public Categoria update(Categoria obj) {

		// o metodo 'save' atualiza o registro quando o obj possuir um 'id'
		return repo.save(obj);
	}
}
