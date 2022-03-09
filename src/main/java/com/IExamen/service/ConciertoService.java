
package com.IExamen.service;

import com.IExamen.entity.Concierto;
import java.util.List;

public interface ConciertoService {
    public List<Concierto> getAllEvents();
    public void saveEvent(Concierto concierto);
    public Concierto getEventById(long id);
    public void deleteEvent(long id);
}
