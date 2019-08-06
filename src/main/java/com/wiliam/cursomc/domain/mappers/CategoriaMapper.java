package com.wiliam.cursomc.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.dto.CategoriaDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

	CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

	CategoriaDTO carToCategoriaDto(Categoria car);
	
	Categoria carToCategoriaDto(CategoriaDTO carDto);
}
