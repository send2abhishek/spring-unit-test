package com.learn.unit.test.spirngunittest.controllers;

import com.learn.unit.test.spirngunittest.fauxspring.Model;
import com.learn.unit.test.spirngunittest.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
