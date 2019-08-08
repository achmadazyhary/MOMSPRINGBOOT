/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Status;

/**
 *
 * @author HARRY-PC
 */
public interface StatusServiceInterface {
    Iterable<Status> findAll();
    Status save(Status status);
    void delete(Integer id);
}
