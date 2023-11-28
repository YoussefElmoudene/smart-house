package com.example.appareil.cotroller;

import com.example.appareil.entity.Appareil;
import com.example.appareil.service.AppareilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/controller/appareil")
@CrossOrigin
public class AppareilController {

    @Autowired
    private AppareilService appareilService;

    @PostMapping("/")
    public Appareil save(@RequestBody Appareil appareil) {
        return appareilService.save(appareil);
    }

    @GetMapping("/id/{id}")
    public Optional<Appareil> findById(@PathVariable Long id) {
        return appareilService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(Long id) {
        appareilService.deleteById(id);
    }

    @GetMapping("/")
    public List<Appareil> findAll() {
        return appareilService.findAll();
    }


}
