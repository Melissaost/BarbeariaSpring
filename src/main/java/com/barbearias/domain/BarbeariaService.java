package com.barbearias.domain;

import com.barbearias.domain.dto.BarbeariaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarbeariaService {

    @Autowired
    private BarbeariaRepository rep;

    public List<BarbeariaDTO> getBarbearias() {

        return rep.findAll().stream().map(b -> BarbeariaDTO.create(b)).collect(Collectors.toList());

    }

    public List<BarbeariaDTO> getBarbeariaById(Long id) {
        return rep.findById(id).stream().map(b -> BarbeariaDTO.create(b)).collect(Collectors.toList());

    }

    public List<BarbeariaDTO> getByBairro(String bairro) {
        return rep.findByBairro(bairro).stream().map(b -> BarbeariaDTO.create(b)).collect(Collectors.toList());
    }

    public BarbeariaDTO insert(Barbearia barbearia) {
        Assert.isNull(barbearia.getId(), "Não foi possível inserir registro");
        return BarbeariaDTO.create(rep.save(barbearia));
    }

    public BarbeariaDTO update(Barbearia barbearia, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro.");

        Optional<Barbearia> optional = rep.findById(id);
        if(optional.isPresent()) {
            Barbearia db = optional.get();
            db.setNome(barbearia.getNome());
            db.setRua(barbearia.getRua());
            System.out.println("Bairro id: " + db.getId());

            rep.save(db);
            return BarbeariaDTO.create(db);
        }else {
            return null;
        }
    }

    public void delete(Long id){
        rep.deleteById(id);
    }

}
