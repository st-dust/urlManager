package com.stdust.urlManager.controllers;

import com.stdust.urlManager.model.Collection;
import com.stdust.urlManager.service.CollectionService;
import com.stdust.urlManager.service.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/collections")
public class CollectionController {
    private final TileService tileService;
    private final CollectionService collectionService;

    @Autowired
    public CollectionController(TileService tileService, CollectionService collectionService) {
        this.tileService = tileService;
        this.collectionService = collectionService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tiles", tileService.findAll());
        model.addAttribute("collection2tiles", collectionService.collection2tiles());
        return "collections/index";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("tile", collectionService.findById(id));
//        return "collections/show";
//    }

    @GetMapping("/new")
    public String newCollection(@ModelAttribute("collection") Collection collection) {
        return  "collections/new";
    }

    @PostMapping
    public String create(@ModelAttribute("collection") @Valid Collection collection,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "collection/edit";
        }

        collectionService.save(collection);
        return "redirect:collections";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("collection", collectionService.findById(id));
        return "collections/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("tile") @Valid Collection collection,
                         BindingResult bindingResult, @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "collections/edit";
        }

        collectionService.update(id, collection);

        return "redirect:/collections";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        collectionService.delete(id);
        return "redirect:/collections";
    }
}
