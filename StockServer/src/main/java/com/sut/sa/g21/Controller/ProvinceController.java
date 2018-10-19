package com.sut.sa.g21.Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Collection;
import java.util.Optional;
import java.util.*;

import javax.persistence.criteria.Order;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sut.sa.g21.Entity.*;
import com.sut.sa.g21.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {
    @Autowired private ProvinceRepository provinceRepository;

    // Province
    @GetMapping("/Provinces")
    public Collection<Province> provinces() {
        return provinceRepository.findAll();
    }
}