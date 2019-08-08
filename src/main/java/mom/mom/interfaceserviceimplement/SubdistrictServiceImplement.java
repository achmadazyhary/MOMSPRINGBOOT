/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.ISubdistrictRepository;
import mom.mom.interfaceservice.SubdistrictServiceInterface;
import mom.mom.model.Subdistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class SubdistrictServiceImplement implements SubdistrictServiceInterface{
    
    @Autowired
    ISubdistrictRepository subdistrictRepository;

    @Override
    public Iterable<Subdistrict> findAll() {
        return subdistrictRepository.findAll();
    }

    @Override
    public Subdistrict save(Subdistrict subdistrict) {
        return subdistrictRepository.save(subdistrict);
    }

    @Override
    public void delete(Integer id) {
        subdistrictRepository.deleteById(id);
    }
    
}
