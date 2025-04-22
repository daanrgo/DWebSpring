package com.example.portico.service;

import com.example.portico.dto.*;
import com.example.portico.entidad.Comida;
import com.example.portico.entidad.Adicional;
import com.example.portico.repositorio.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ComidaServiceImpl implements ComidaService {
    
    @Autowired
    private ComidaRepository comidaRepository;

    // Implementación de métodos CRUD
    @Override
    public Comida searchById(Integer id) {
        if (id == null) return null;
        return comidaRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Comida> searchAll() {
        return comidaRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        comidaRepository.deleteById(id);
    }

    @Override
    public Comida update(Comida comida) {
        if (comida == null || comida.getId() == null) return null;
        return comidaRepository.save(comida);
    }

    @Override
    public Comida add(Comida comida) {
        if (comida == null) return null;
        return comidaRepository.save(comida);
    }

    // Implementación de métodos DTO
    @Override
    public ComidaDTO convertToComidaDTO(Comida comida) {
        if (comida == null) return null;
        
        return new ComidaDTO(
            comida.getId(),
            comida.getName(),
            comida.getPrice() != null ? comida.getPrice().doubleValue() : 0.0,
            comida.getDescription(),
            comida.getImagen(),
            convertAdicionalesToDTO(comida.getAdicionales())
        );
    }

    @Override
    public AdicionalesDTO getAdicionalesDTO(Integer comidaId, Map<Integer, Boolean> selecciones) {
        if (comidaId == null) return null;
        
        Comida comida = searchById(comidaId);
        if (comida == null) return null;
        
        Map<Integer, Boolean> seleccionesFinales = new HashMap<>();
        if (comida.getAdicionalesSeleccionados() != null) {
            seleccionesFinales.putAll(comida.getAdicionalesSeleccionados());
        }
        if (selecciones != null) {
            seleccionesFinales.putAll(selecciones);
        }
        
        return new AdicionalesDTO(
            comidaId,
            seleccionesFinales,
            convertAdicionalesToMapDTO(comida.getAdicionales())
        );
    }

    @Override
    public DTOIdUsuarioComida getComidaDTOForUser(Integer userId, Integer comidaId) {
        if (userId == null || comidaId == null) return null;
        Comida comida = searchById(comidaId);
        return new DTOIdUsuarioComida(userId, convertToComidaDTO(comida));
    }

    @Override
    public DTOIdUsuarioComidas getAllComidasDTOForUser(Integer userId) {
        if (userId == null) return null;
        return new DTOIdUsuarioComidas(
            userId, 
            convertComidasToDTOList(searchAll())
        );
    }

    // Implementación de métodos de conversión
    @Override
    public List<ComidaDTO> convertComidasToDTOList(Collection<Comida> comidas) {
        if (comidas == null) return Collections.emptyList();
        return comidas.stream()
            .map(this::convertToComidaDTO)
            .collect(Collectors.toList());
    }

    @Override
    public List<AdicionalDTO> convertAdicionalesToDTO(List<Adicional> adicionales) {
        if (adicionales == null) return Collections.emptyList();
        return adicionales.stream()
            .map(this::convertToAdicionalDTO)
            .collect(Collectors.toList());
    }

    // Métodos auxiliares privados
    private Map<Integer, AdicionalDTO> convertAdicionalesToMapDTO(List<Adicional> adicionales) {
        if (adicionales == null) return Collections.emptyMap();
        return adicionales.stream()
            .collect(Collectors.toMap(
                Adicional::getId,
                this::convertToAdicionalDTO,
                (existing, replacement) -> existing
            ));
    }

    private AdicionalDTO convertToAdicionalDTO(Adicional adicional) {
        if (adicional == null) return null;
        return new AdicionalDTO(
            adicional.getId(),
            adicional.getName(),
            adicional.getPrice() != null ? adicional.getPrice().doubleValue() : 0.0
        );
    }
}