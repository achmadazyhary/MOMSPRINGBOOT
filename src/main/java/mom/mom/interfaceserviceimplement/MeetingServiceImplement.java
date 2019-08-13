/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mom.mom.interfaceserviceimplement;

import mom.mom.interfacerepositoty.IMeetingRepository;
import mom.mom.interfaceservice.MeetingServiceInterface;
import mom.mom.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class MeetingServiceImplement implements MeetingServiceInterface{

    @Autowired
    private IMeetingRepository meetingRepository;
    
    @Override
    public Iterable<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public void delete(Integer id) {
        meetingRepository.deleteById(id);
    }
    
}
