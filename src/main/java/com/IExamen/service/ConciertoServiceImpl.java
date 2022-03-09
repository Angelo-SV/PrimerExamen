
package com.IExamen.service;

import com.IExamen.entity.Concierto;
import com.IExamen.repository.ConciertoRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConciertoServiceImpl implements ConciertoService{
    
    @Autowired
    private ConciertoRepository conciertoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Concierto> getAllEvents() {
        return(List<Concierto>)conciertoRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEvent(Concierto concierto) {
        conciertoRepository.save(concierto);
    }

    @Override
    @Transactional(readOnly = true)
    public Concierto getEventById(long id) {
        return conciertoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteEvent(long id) {
        conciertoRepository.deleteById(id);
    }
}
