package com.pichincha.cuentamicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.cuentamicroservice.models.Cuenta;
import com.pichincha.cuentamicroservice.repositories.CuentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {

    @Autowired
    private final CuentaRepository repo;

    public List<Cuenta> getAllCuentas(){
        return repo.findAll();
    }

    public Cuenta getCuentaById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Cuenta save(Cuenta cuenta){
        Cuenta nuevaCuenta = repo.save(cuenta);
        return nuevaCuenta;
    }

    public void deleteCuenta(Long id){
        repo.deleteById(id);
    }


}
