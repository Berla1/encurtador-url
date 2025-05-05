package com.encurtador_url.controller;

import com.encurtador_url.dto.UrlDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<Void> postUrl(@RequestBody UrlDTO request){

        return ResponseEntity.ok().build();
    }
}
