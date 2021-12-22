package com.learn.unit.test.spirngunittest.controllers;

import com.learn.unit.test.spirngunittest.fauxspring.Model;
import com.learn.unit.test.spirngunittest.fauxspring.ModelImpl;
import com.learn.unit.test.spirngunittest.services.SpecialtyService;
import com.learn.unit.test.spirngunittest.services.VetService;
import com.learn.unit.test.spirngunittest.services.map.SpecialityMapService;
import com.learn.unit.test.spirngunittest.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;


    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);
    }

    @Test
    void listVets() {
        Model model = new ModelImpl();
        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);
    }
}