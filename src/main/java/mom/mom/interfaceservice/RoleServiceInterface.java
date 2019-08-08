/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Role;

/**
 *
 * @author HARRY-PC
 */
public interface RoleServiceInterface {
    Iterable<Role> findAll();
    Role save(Role role);
    void delete(Integer id);
}
