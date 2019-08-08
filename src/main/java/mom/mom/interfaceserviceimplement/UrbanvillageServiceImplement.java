/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IUrbanvillageRepository;
import mom.mom.interfaceservice.UrbanvillageServiceInterface;
import mom.mom.model.Urbanvillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class UrbanvillageServiceImplement implements UrbanvillageServiceInterface{
    
    @Autowired
    private IUrbanvillageRepository urbanvillageRepository;

    @Override
    public Iterable<Urbanvillage> findAll() {
        return urbanvillageRepository.findAll();
    }

    @Override
    public Urbanvillage save(Urbanvillage urbanvillage) {
        return urbanvillageRepository.save(urbanvillage);
    }

    @Override
    public void delete(Integer id) {
        urbanvillageRepository.deleteById(id);
    }
    
}
