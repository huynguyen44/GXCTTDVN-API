package com.gxcttdvnapi.api.controllers;
import com.gxcttdvnapi.api.exceptions.ResourceNotFoundException;
import com.gxcttdvnapi.api.models.Class;
import com.gxcttdvnapi.api.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;


@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/all")
    public List<Class> getAllClass(){
        return classRepository.findAll();
    }

}
