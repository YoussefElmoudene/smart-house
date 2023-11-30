package com.example.appareil.service;

import com.example.appareil.entity.Appareil;
import com.example.appareil.repository.AppareilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppareilService {



    @Autowired
    private AppareilRepository appareilRepository;

    public  Appareil save(Appareil appareil) {
        return appareilRepository.save(appareil);
    }

    public Optional<Appareil> findById(Long id) {
        return appareilRepository.findById(id);
    }

    public void deleteById(Long id) {
        appareilRepository.deleteById(id);
    }

    public List<Appareil> findAll() {
        return appareilRepository.findAll();
    }

    public void update(Long id,Appareil appInfo) {
        Appareil appareil=appareilRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("app not found with id " + id));
        appareil.setState(appInfo.isState());
        appareilRepository.save(appareil);
    }


}
