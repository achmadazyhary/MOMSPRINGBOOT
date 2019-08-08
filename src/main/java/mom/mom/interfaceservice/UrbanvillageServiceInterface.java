/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Urbanvillage;

/**
 *
 * @author HARRY-PC
 */
public interface UrbanvillageServiceInterface {
    Iterable<Urbanvillage> findAll();
    Urbanvillage save(Urbanvillage urbanvillage);
    void delete(Integer id);
}
