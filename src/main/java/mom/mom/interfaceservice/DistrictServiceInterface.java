/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.District;

/**
 *
 * @author HARRY-PC
 */
public interface DistrictServiceInterface {
    Iterable<District> findAll();
    District save(District district);
    void delete(Integer id);
}
