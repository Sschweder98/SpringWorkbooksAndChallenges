package com.ltp.workbook.controllers;

import com.ltp.workbook.models.Show;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class WorkbookController {
    
    @GetMapping("/shows")
    public String getShows(Model model) {
        ArrayList<Show> shows = new ArrayList<Show>();
        shows.add(new Show("Breaking Bad", "Ozymandias", 10.0));
        shows.add(new Show("Attack on Titan", "Hero", 9.9));
        shows.add(new Show("Attack on Titan", "Perfect Game", 9.9));
        shows.add(new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9));
        shows.add(new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));
        model.addAttribute("shows", shows);
        return "shows";
    }

}
