package com.sut.sa.g21.Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.criteria.Order;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sut.sa.g21.Entity.*;
import com.sut.sa.g21.Repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GenderController {
    @Autowired
    private GenderRepository genderRepository;

    public GenderController (GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    // Gender
    @GetMapping("/Genders")
    public Collection<Gender> genders() {
        return genderRepository.findAll();
    }
}
