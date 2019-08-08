/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Subdistrict;

/**
 *
 * @author HARRY-PC
 */
public interface SubdistrictServiceInterface {
    Iterable<Subdistrict> findAll();
    Subdistrict save(Subdistrict subdistrict);
    void delete(Integer id);
}
