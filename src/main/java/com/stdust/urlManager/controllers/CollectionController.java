package com.stdust.urlManager.controllers;

import com.stdust.urlManager.model.Collection;
import com.stdust.urlManager.model.Person;
import com.stdust.urlManager.security.PersonDetails;
import com.stdust.urlManager.service.CollectionService;
import com.stdust.urlManager.service.PersonDetailsService;
import com.stdust.urlManager.service.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final PersonDetailsService personDetailsService;

    @Autowired
    public CollectionController(TileService tileService, CollectionService collectionService, PersonDetailsService personDetailsService) {
        this.tileService = tileService;
        this.collectionService = collectionService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("person", getPersonInfo());
        model.addAttribute("tiles", tileService.findAll());
        model.addAttribute("collection2tiles", collectionService.collection2tiles());
        return "collections/index";
    }

    private Person getPersonInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getPerson();
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
    public String create(@ModelAttribute("collection") Collection collection,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "collection/edit";
        }

        collection.setCollectionOwner(getPersonInfo());
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
        collection.setCollectionOwner(getPersonInfo());
        collectionService.update(id, collection);

        return "redirect:/collections";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        collectionService.delete(id);
        return "redirect:/collections";
    }

    @DeleteMapping("/delete-current-user/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        personDetailsService.delete(id);
        SecurityContextHolder.clearContext();
        return "redirect:/collections";
    }
}
