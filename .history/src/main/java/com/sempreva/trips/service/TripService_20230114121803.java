package com.sempreva.trips.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sempreva.trips.dto.TripDto;
import com.sempreva.trips.model.Trip;
import com.sempreva.trips.repository.TripRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TripService {
    
    @Autowired
    private TripRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<TripDto> getTrips(Pageable pagination) { 
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, TripDto.class));
    
    }

    public TripDto getTripById(Long id) {
        Trip trip = repository
                    .findById(id)
                    .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(trip, TripDto.class);
    }

    public TripDto createTrip(TripDto newTrip) {

        Trip trip = modelMapper.map(newTrip, Trip.class);

        repository.save(trip);

        return modelMapper.map(trip, TripDto.class);

    }

    public TripDto updateTrip(Long id, TripDto newTrip) {
        Trip trip = modelMapper.map(newTrip, Trip.class);
        trip.setId(id);

        trip = repository.save(trip);

        return modelMapper.map(trip, TripDto.class);

    }

    public void deleteTrip(Long id) {
        repository.deleteById(id);
    }

}
