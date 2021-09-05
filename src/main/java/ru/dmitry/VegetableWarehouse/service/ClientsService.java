package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.repo.ClientsRepository;

import java.util.List;
@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    //Конструктор
    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    //Read id
    public Clients findById(Long id){
        return clientsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Clients> findAll(){
        return clientsRepository.findAll();
    }
    //Save one unit
    public Clients save(Clients clients){
        return clientsRepository.save(clients);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            clientsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
