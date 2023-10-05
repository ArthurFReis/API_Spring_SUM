package com.arthur.somando.Service;

import com.arthur.somando.Entity.SomaNumeros;
import com.arthur.somando.Repository.SomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SomaService {

    @Autowired
    private SomaRepository somaRepository;

    public List<SomaNumeros> listaSomaNumeros(){
        return somaRepository.findAll();
    }

    public SomaNumeros salvar(SomaNumeros somaNumeros){



         int num1 = somaNumeros.getNum1();
         int num2 = somaNumeros.getNum2();


         somaNumeros.setSoma(num1 + num2);




        return somaRepository.save(somaNumeros);
    }



    public Optional<SomaNumeros> buscarPorId(Long id){
        return somaRepository.findById(id);
    }

    public void removerPorId(Long id){
        somaRepository.deleteById(id);
    }

}
