package com.wiliam.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.dto.CategoriaDTO;
import com.wiliam.cursomc.services.CategoriaService;

// notacao diz ao spring que esta classe eh um Rest controller
@RestController
/* notacao responsavel por mapear requisicoes Web para metodos
*e o 'value' corresponde ao endpoint 
*/
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// o @GetMapping eh um atalho para o mapeamento acima
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> find(@PathVariable() Integer id) {
		Categoria obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	// @RequestMapping notacao para mapear requisicoes Web
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		//  '.fromCurrentRequest()' retorna a URI utilizada para inserir
		//
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}"/*, method = RequestMethod.PUT*/)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable() Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		
		List<CategoriaDTO> listaDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		//List<CategoriaDTO> listaDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList()));
		return ResponseEntity.ok().body(listaDto);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		
		Page<CategoriaDTO> listaDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listaDto);
	}
}
