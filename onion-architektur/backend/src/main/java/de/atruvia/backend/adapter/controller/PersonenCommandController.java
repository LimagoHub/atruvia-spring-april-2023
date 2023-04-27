package de.atruvia.backend.adapter.controller;


import de.atruvia.backend.adapter.dto.PersonDto;
import de.atruvia.backend.adapter.mapper.PersonDtoMapper;
import de.atruvia.backend.application.PersonenHandler;
import de.atruvia.service.PersonenService;
import de.atruvia.service.PersonenServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/personen")
@RequiredArgsConstructor
public class PersonenCommandController {


    private final PersonenHandler handler;
    private final PersonDtoMapper mapper;

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws PersonenServiceException {
        if(handler.handleDelete(id)) {

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody PersonDto dto, UriComponentsBuilder builder) throws PersonenServiceException{
        handler.handleAnlegen(mapper.convert(dto));
        UriComponents uriComponent = builder.path("/v1/personen/{id}").buildAndExpand(dto.getId());
        return ResponseEntity.created(uriComponent.toUri()).build();
    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody PersonDto dto) throws PersonenServiceException{
        if( !id.equals(dto.getId())) throw new IllegalArgumentException("Upps");

        handler.handleAendern(mapper.convert(dto));

        return ResponseEntity.ok().build();
    }


}
