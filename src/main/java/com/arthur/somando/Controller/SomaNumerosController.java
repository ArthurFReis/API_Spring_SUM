package com.arthur.somando.Controller;

import com.arthur.somando.Entity.SomaNumeros;
import com.arthur.somando.Service.SomaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/soma")
public class SomaNumerosController {

    @Autowired
    private SomaService somaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SomaNumeros salvar(@RequestBody SomaNumeros soma){
        return somaService.salvar(soma);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SomaNumeros> listaSomaNumeros(){
        return somaService.listaSomaNumeros();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SomaNumeros buscarClientePorId(@PathVariable("id") Long id){
        return somaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSoma(@PathVariable("id") Long id){
        somaService.buscarPorId(id)
                .map(somaNumeros -> {
                    somaService.removerPorId(somaNumeros.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarSoma(@PathVariable("id") Long id,  @RequestBody SomaNumeros cliente){
        somaService.buscarPorId(id)
                .map(clienteBase -> {
                    modelMapper.map(cliente, clienteBase);
                    somaService.salvar(clienteBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }

}
