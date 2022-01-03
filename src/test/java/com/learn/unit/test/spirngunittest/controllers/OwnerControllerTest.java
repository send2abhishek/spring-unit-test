package com.learn.unit.test.spirngunittest.controllers;

import com.learn.unit.test.spirngunittest.fauxspring.BindingResult;
import com.learn.unit.test.spirngunittest.model.Owner;
import com.learn.unit.test.spirngunittest.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_5 = "redirect:/owners/5";
    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    @Mock
    BindingResult result;


    @Test
    void processFindFormWildCardString() {

        Owner owner = new Owner(1L, "abhishek", "aryan");

        List<Owner> ownerList=new ArrayList<>();
        final ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);

        // when
        String viewName=controller.processFindForm(owner,result,null);

        // then
        assertThat("%aryan%").isEqualToIgnoringCase(captor.getValue());
    }

    @Test
    void processCreationFormHasError() {
        // Bdd approach

        // given
        Owner owner = new Owner(1L, "abhishek", "aryan");
        given(result.hasErrors()).willReturn(true);

        // when
        String viewName=controller.processCreationForm(owner,result);

        //then
        assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
    }

    @Test
    void processCreationFormHasNoError() {
        // Bdd approach

        // given
        Owner owner = new Owner(5L, "abhishek", "aryan");
        given(result.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner);

        // when
        String viewName=controller.processCreationForm(owner,result);

        //then
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);
    }
}