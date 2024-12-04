/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deeon_labti.parkiran.repository;

import com.deeon_labti.parkiran.model.ModelParkiran;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hyun
 */
@Repository
public interface ParkiranRepository extends JpaRepository<ModelParkiran, Long> {
    public Optional<ModelParkiran> findByPlatNomor(String platNomor);
}
