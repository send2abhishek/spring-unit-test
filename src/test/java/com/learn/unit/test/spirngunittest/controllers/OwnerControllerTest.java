package com.learn.unit.test.spirngunittest.controllers;

import com.learn.unit.test.spirngunittest.fauxspring.BindingResult;
import com.learn.unit.test.spirngunittest.fauxspring.Model;
import com.learn.unit.test.spirngunittest.model.Owner;
import com.learn.unit.test.spirngunittest.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
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

    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void setUp() {
        given(ownerService.findAllByLastNameLike(captor.capture()))
                .willAnswer(invocationOnMock -> {

                    List<Owner> ownerList = new ArrayList<>();

                    String name = invocationOnMock.getArgument(0);

                    if (name.equals("%aryan%")) {
                        ownerList.add(new Owner(1L, "abhishek", "aryan"));

                        return ownerList;
                    }

                    else if(name.equals("%don'tFind%")){
                      return   ownerList;
                    }

                    else if(name.equals("%Find%")){
                        ownerList.add(new Owner(1L, "abhishek", "aryan"));
                        ownerList.add(new Owner(2L, "abhishek2", "aryan2"));
                        return   ownerList;
                    }

                    throw new RuntimeException("Invalid argument");

                });
    }

    @Test
    void processFindFormWildCardFound() {

        Owner owner = new Owner(1L, "abhishek", "Find");
        // when
        String viewName = controller.processFindForm(owner, result, Mockito.mock(Model.class));

        // then
        assertThat("%Find%").isEqualToIgnoringCase(captor.getValue());
        assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);
    }

    @Test
    void processFindFormWildCardString() {

        Owner owner = new Owner(1L, "abhishek", "aryan");

//        List<Owner> ownerList = new ArrayList<>();
//        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);

        // when
        String viewName = controller.processFindForm(owner, result, null);

        // then
        assertThat("%aryan%").isEqualToIgnoringCase(captor.getValue());
        assertThat("redirect:/owners/1").isEqualToIgnoringCase(viewName);
    }

    @Test
    void processFindFormWildCardNotFound() {

        Owner owner = new Owner(1L, "abhishek", "don'tFind");
        // when
        String viewName = controller.processFindForm(owner, result, null);

        // then
        assertThat("%don'tFind%").isEqualToIgnoringCase(captor.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
    }


    @Test
    void processCreationFormHasError() {
        // Bdd approach

        // given
        Owner owner = new Owner(1L, "abhishek", "aryan");
        given(result.hasErrors()).willReturn(true);

        // when
        String viewName = controller.processCreationForm(owner, result);

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
        String viewName = controller.processCreationForm(owner, result);

        //then
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);
    }
}