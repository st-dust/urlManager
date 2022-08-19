package com.stdust.urlManager.controllers;

import com.stdust.urlManager.model.Tile;
import com.stdust.urlManager.service.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

    @GetMapping("/new")
    public String newTile(@ModelAttribute("tile") Tile tile) {
        return  "tiles/new";
    }

    @PostMapping
    public String create(@ModelAttribute("tile") @Valid Tile tile,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        tileService.save(tile);
        return "redirect:tiles";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("tile", tileService.findById(id));
        return "tiles/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("tile") @Valid Tile tile,
                         BindingResult bindingResult, @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "tiles/edit";
        }

        tileService.update(id, tile);

        return "redirect:/tiles";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        tileService.delete(id);
        return "redirect:/tiles";
    }
}
