package de.atruvia.webapp.presentation.controller;

import de.atruvia.webapp.presentation.dto.PersonDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/personen")
public class PersonenCommandController {



    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if("1234".equals(id)) {
            System.out.println("Person wird geloescht");
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody PersonDto dto, UriComponentsBuilder builder) {
        System.out.println(dto + "wird gespeichert");
        UriComponents uriComponent = builder.path("/v1/personen/{id}").buildAndExpand(dto.getId());
        return ResponseEntity.created(uriComponent.toUri()).build();
    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody PersonDto dto) {
        if( !id.equals(dto.getId())) throw new IllegalArgumentException("Upps");

        System.out.println(dto + "wird geaendert");

        return ResponseEntity.ok().build();
    }


}
