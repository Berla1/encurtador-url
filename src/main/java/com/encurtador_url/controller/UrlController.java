package com.encurtador_url.controller;

import com.encurtador_url.dto.ShortenUrlRequest;
import com.encurtador_url.dto.ShortenUrlResponse;
import com.encurtador_url.model.Url;
import com.encurtador_url.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UrlController {

    private final UrlRepository repository;

    public UrlController(UrlRepository repository) {
        this.repository = repository;
    }
    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> postUrl(@RequestBody ShortenUrlRequest request, HttpServletRequest servletRequest) {
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(8);
        } while (repository.findUrlById(id).isPresent());

        Url newUrl = new Url(id, request.url(), LocalDateTime.now().plusDays(30));
        repository.save(newUrl);

        String redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);
        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }
}
