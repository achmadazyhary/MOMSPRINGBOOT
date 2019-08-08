/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Province;

/**
 *
 * @author HARRY-PC
 */
public interface ProvinceServiceInterface {
    Iterable<Province> findAll();
    Province save(Province province);
    void delete(Integer id);
}
