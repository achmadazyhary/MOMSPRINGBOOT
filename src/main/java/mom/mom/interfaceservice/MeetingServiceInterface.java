/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceservice;

import mom.mom.model.Meeting;

/**
 *
 * @author HARRY-PC
 */
public interface MeetingServiceInterface{
    Iterable<Meeting> findAll();
    Meeting save(Meeting meeting);
    void delete(Integer id);
}
