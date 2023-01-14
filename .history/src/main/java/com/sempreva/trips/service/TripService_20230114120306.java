package com.sempreva.trips.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sempreva.trips.dto.TripDto;
import com.sempreva.trips.repository.TripRepository;

@Service
public class TripService {
    
    @Autowired
    private TripRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<TripDto> getTrips(Pageable pagination) { 
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, destination: TripDto.class));
        

    }

}
