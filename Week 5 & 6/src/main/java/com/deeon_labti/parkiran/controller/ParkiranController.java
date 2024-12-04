/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deeon_labti.parkiran.controller;

import com.deeon_labti.parkiran.model.ModelParkiran;
import com.deeon_labti.parkiran.repository.ParkiranRepository;
import com.deeon_labti.parkiran.service.ParkiranService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author hyun
 */
@Controller
public class ParkiranController {
    
    @Autowired
    private ParkiranService svc;
    
    public void masukParkir(ModelParkiran park) {
        svc.masukParkir(park);
    }
    
    public String keluarParkir(String platNomor) {
        return svc.keluarParkir(platNomor);
    }
    
    public List<ModelParkiran> getAllParkiran() {
        return svc.getAllParkiran();
    }
}