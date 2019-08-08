/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IDistrictRepository;
import mom.mom.interfaceservice.DistrictServiceInterface;
import mom.mom.model.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class DistrictServiceImplement implements DistrictServiceInterface{
    
    @Autowired
    private IDistrictRepository districtRepository;

    @Override
    public Iterable<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }

    @Override
    public void delete(Integer id) {
        districtRepository.deleteById(id);
    }
    
}
