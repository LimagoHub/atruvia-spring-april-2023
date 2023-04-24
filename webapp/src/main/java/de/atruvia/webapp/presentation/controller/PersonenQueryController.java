package de.atruvia.webapp.presentation.controller;

import de.atruvia.webapp.presentation.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/personen")
public class PersonenQueryController {


    @Operation(summary = "Get a person by person id")
    @ApiResponse(responseCode = "200", description = "Person wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden" , content = @Content)
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler", content = @Content)

    @GetMapping(path="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDto> findPersonById(@PathVariable  String id) {
        if("1234".equals(id))
            return ResponseEntity.ok(PersonDto.builder().id(id).vorname("John").nachname("Doe").build());
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Get all persons")
    @ApiResponse(responseCode = "200", description = "Ok")
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler", content = @Content)

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PersonDto>> findeAlle(
            @RequestParam(required = false, defaultValue = "") String vorname,
            @RequestParam(required = false, defaultValue = "") String nachname) {
        System.out.println(String.format("Vorname = %s, nachname = %s", vorname, nachname));
        var personen = List.of(
                PersonDto.builder().id("1").vorname("John").nachname("Doe").build(),
                PersonDto.builder().id("2").vorname("John").nachname("Wayne").build(),
                PersonDto.builder().id("3").vorname("John").nachname("Wick").build(),
                PersonDto.builder().id("4").vorname("John").nachname("Rambo").build(),
                PersonDto.builder().id("5").vorname("John").nachname("McClain").build()

        );

        return ResponseEntity.ok(personen);
    }



//    @PostMapping("/functions/toupper")
//    public PersonDto toUpper(@RequestBody  PersonDto dto) {
//        dto.setNachname(dto.getNachname().toUpperCase());
//        return dto;
//    }

}
