package com.mw.serverrest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ServerRestController {

  @GetMapping("/")
  public ResponseEntity hello() {
    SimplyDto simplyDto = new SimplyDto();
    simplyDto.setName("Name of simply dto");

    Optional<SimplyDto> stringOptional = Optional.of(simplyDto);

    return ResponseEntity.badRequest().body("bad request");
    //return ResponseEntity.of(stringOptional);
  }

  @GetMapping("/list")
  public ResponseEntity<List<SimplyDto>> list() {
    SimplyDto simplyDto = new SimplyDto();
    simplyDto.setName("Name of simply dto");
    return ResponseEntity.of(Optional.of(Collections.singletonList(simplyDto)));
  }
}
