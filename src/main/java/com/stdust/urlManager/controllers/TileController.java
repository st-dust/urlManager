package com.stdust.urlManager.controllers;

import com.stdust.urlManager.service.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("tiles")
public class TileController {
    private final TileService tileService;

    @Autowired
    public TileController(TileService tileService) {
        this.tileService = tileService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tiles", tileService.findAll());
        return "tiles/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("tile", tileService.findById(id));
        return "tiles/show";
    }
}
