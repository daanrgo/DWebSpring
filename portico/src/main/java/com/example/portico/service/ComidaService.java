package com.example.portico.service;

import com.example.portico.dto.*;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.Adicional;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ComidaService {
    
    // Métodos básicos de CRUD
    Comida searchById(Integer id);
    Collection<Comida> searchAll();
    void deleteById(int id);
    Comida update(Comida comida);
    Comida add(Comida comida);
    
    // Métodos para DTOs
    ComidaDTO convertToComidaDTO(Comida comida);
    AdicionalesDTO getAdicionalesDTO(Integer comidaId, Map<Integer, Boolean> selecciones);
    DTOIdUsuarioComida getComidaDTOForUser(Integer userId, Integer comidaId);
    DTOIdUsuarioComidas getAllComidasDTOForUser(Integer userId);
    
    // Métodos de conversión
    List<ComidaDTO> convertComidasToDTOList(Collection<Comida> comidas);
    List<AdicionalDTO> convertAdicionalesToDTO(List<Adicional> adicionales);
}