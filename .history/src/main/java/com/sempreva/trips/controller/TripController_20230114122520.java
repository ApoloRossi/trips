package com.sempreva.trips.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sempreva.trips.dto.TripDto;
import com.sempreva.trips.service.TripService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/trips")
public class TripController {
        
    @Autowired
    private TripService service;

    @GetMapping
    public Page<TripDto> listar(@PageableDefault(size = 10) Pageable pagination) {
        return service.getTrips(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDto> detalhar(@PathVariable @NotNull Long id) {
        TripDto dto = service.getTripById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TripDto> cadastrar(@RequestBody @Valid TripDto dto, UriComponentsBuilder uriBuilder) {
        TripDto trip = service.createTrip(dto);
        URI endereco = uriBuilder.path("/trip/{id}").buildAndExpand(trip.getId()).toUri();

        return ResponseEntity.created(endereco).body(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid TripDto dto) {
        TripDto atualizado = service.updateTrip(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TripDto> remover(@PathVariable @NotNull Long id) {
        service.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }


}
