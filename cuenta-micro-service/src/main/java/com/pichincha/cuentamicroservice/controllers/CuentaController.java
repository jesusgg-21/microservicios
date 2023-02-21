package com.pichincha.cuentamicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.cuentamicroservice.models.Cuenta;
import com.pichincha.cuentamicroservice.services.CuentaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cuenta")
@AllArgsConstructor
public class CuentaController {

    @Autowired
    private final CuentaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Cuenta>> getAll(){
        List<Cuenta> cuentas = service.getAllCuentas();
        if (cuentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(cuentas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getById(@PathVariable("id") long id){
        Cuenta cuenta = service.getCuentaById(id);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cuenta);
        }
    }

    @PostMapping()
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta){
        Cuenta ncuenta = service.save(cuenta);
        return ResponseEntity.ok(ncuenta);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cuenta> deletePersona(@PathVariable("id") long id) {
        try {
            service.deleteCuenta(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/bycliente/{id}")
    public ResponseEntity<List<Cuenta>> getByPersonId(@PathVariable("id") long id){
        List<Cuenta> cuentas = service.byClienteId(id);
        if (cuentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(cuentas);
        }
    }

}
