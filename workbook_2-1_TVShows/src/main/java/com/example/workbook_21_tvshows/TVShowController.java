package com.example.workbook_21_tvshows;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TVShowController {
    @GetMapping("/shows")
    public String getShows(){
        return "shows";
    }
}
