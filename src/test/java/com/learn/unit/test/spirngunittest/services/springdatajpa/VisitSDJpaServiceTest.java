package com.learn.unit.test.spirngunittest.services.springdatajpa;

import com.learn.unit.test.spirngunittest.model.Visit;
import com.learn.unit.test.spirngunittest.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {

        Visit visit = new Visit();

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        // set the condition to return one set of visit object
        when(repository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();
        // first assertion
        assertThat(foundVisits).hasSize(1);
        // second assertion
        verify(repository).findAll();
    }

    @DisplayName("Test Find By Id")
    @Test
    void findById() {

        Visit visit = new Visit();

        when(repository.findById(1L)).thenReturn(Optional.of(visit));

        Visit returnVisit = service.findById(1L);
        assertThat(returnVisit).isNotNull();
        verify(repository).findById(anyLong());
    }

    @DisplayName("Test save")
    @Test
    void save() {

        Visit visit = new Visit();
        when(repository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(new Visit());

        assertThat(savedVisit).isNotNull();
        verify(repository).save(any(Visit.class));
    }

    @DisplayName("Test delete ")
    @Test
    void delete() {
        Visit visit = new Visit();
        service.delete(visit);

        // verify the arguments
        verify(repository).delete(any(Visit.class));
    }

    @DisplayName("Test delete By Id")
    @Test
    void deleteById() {

        service.deleteById(1L);
        // verify the test
        verify(repository, atLeast(1)).deleteById(anyLong());
    }

    @Test
    void testDoThrow() {

        doThrow(new RuntimeException("exception at runtime")).when(repository).delete(any());
        assertThrows(RuntimeException.class, () -> repository.delete(new Visit()));
        verify(repository).delete(any());
    }
}