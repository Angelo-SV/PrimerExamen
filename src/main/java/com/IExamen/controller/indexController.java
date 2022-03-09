
package com.IExamen.controller;

import com.IExamen.entity.Concierto;
import com.IExamen.service.ConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class indexController {
    @Autowired
    private ConciertoService conciertoService;
    
    @GetMapping("/index")
    public String index(Model model){
        List<Concierto> listaConcierto = conciertoService.getAllEvents();
        model.addAttribute("concierto", listaConcierto);
        return "/index";
    }
    
    @GetMapping("/nuevoEvento")
    public String nuevoEvento(Model model){
        model.addAttribute("concierto", new Concierto());
        return "/nuevoEvento";
    }
    
    @PostMapping("/guardarEvento")
    public String guardarEvento(@ModelAttribute Concierto concierto){
        conciertoService.saveEvent(concierto);
        return "redirect:/index";
    }
    
    @GetMapping("/eliminarEvento/{id}")
    public String eliminarEvento(@PathVariable("id") long idConcierto){
        conciertoService.deleteEvent(idConcierto);
        return "/index";
    }
}
