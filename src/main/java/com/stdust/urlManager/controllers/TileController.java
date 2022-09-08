package com.stdust.urlManager.controllers;

import com.stdust.urlManager.model.Collection;
import com.stdust.urlManager.model.Tile;
import com.stdust.urlManager.service.CollectionService;
import com.stdust.urlManager.service.TileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tiles")
@SessionAttributes({"currentCollection"})
public class TileController {
    private final TileService tileService;
    private final CollectionService collectionService;
    private final ModelMapper modelMapper;

    @ModelAttribute("currentCollection")
    public Collection currentCollection() {
        return new Collection();
    }

    @Autowired
    public TileController(TileService tileService, CollectionService collectionService, ModelMapper modelMapper) {
        this.tileService = tileService;
        this.collectionService = collectionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tiles", tileService.findAll());
        model.addAttribute("collections", collectionService.findAll());
        return "tiles/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("tile", tileService.findById(id));
        return "tiles/show";
    }

    @GetMapping("/new/{collectionId}")
    public String newTile(@ModelAttribute("newTile") Tile newTile, Model model,
                          @PathVariable("collectionId") int collectionId) {
        model.addAttribute("currentCollection", collectionService.findById(collectionId));
        return  "tiles/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("newTile") @Valid Tile newTile,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "tiles/new";
        }
        newTile.setCollection((Collection) model.getAttribute("currentCollection"));
        tileService.save(newTile);
        return "redirect:/collections";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("tile", tileService.findById(id));
        return "tiles/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("tile") @Valid Tile tile,
                         BindingResult bindingResult, @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "tiles/edit";
        }

        tile.setCollection(tileService.findById(id).getCollection());
        tileService.update(id, tile);

        return "redirect:/collections";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        tileService.delete(id);
        return "redirect:/collections";
    }
}
