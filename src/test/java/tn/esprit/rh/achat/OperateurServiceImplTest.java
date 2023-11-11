package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class OperateurServiceImplTest {

    @Mock
    private OperateurRepository operateurRepository;

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Test
    void testRetrieveAllOperateurs() {
        // Mock the behavior of the repository method
        List<Operateur> operateurs = new ArrayList<>();
        when(operateurRepository.findAll()).thenReturn(operateurs);

        // Invoke the method and verify the result
        List<Operateur> retrievedOperateurs = operateurService.retrieveAllOperateurs();
        assertEquals(operateurs, retrievedOperateurs);

        // Verify that findAll method of operateurRepository was called once
        verify(operateurRepository, times(1)).findAll();
    }

    @Test
    void testAddOperateur() {
        // Create a sample operateur
        Operateur operateur = new Operateur();

        // Mock the behavior of the repository method
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        // Invoke the method and verify the result
        Operateur addedOperateur = operateurService.addOperateur(operateur);
        assertEquals(operateur, addedOperateur);

        // Verify that save method of operateurRepository was called once
        verify(operateurRepository, times(1)).save(operateur);
    }

    @Test
    void testDeleteOperateur() {
        // Mock the behavior of the repository method
        doNothing().when(operateurRepository).deleteById(anyLong());

        // Invoke the method
        operateurService.deleteOperateur(1L);

        // Verify that deleteById method of operateurRepository was called once with the correct argument
        verify(operateurRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateOperateur() {
        // Create a sample operateur
        Operateur operateur = new Operateur();

        // Mock the behavior of the repository method
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        // Invoke the method and verify the result
        Operateur updatedOperateur = operateurService.updateOperateur(operateur);
        assertEquals(operateur, updatedOperateur);

        // Verify that save method of operateurRepository was called once
        verify(operateurRepository, times(1)).save(operateur);
    }

    @Test
    void testRetrieveOperateur() {
        // Create a sample operateur ID
        Long operateurId = 1L;

        // Mock the behavior of the repository method
        Operateur operateur = new Operateur();
        when(operateurRepository.findById(operateurId)).thenReturn(Optional.of(operateur));

        // Invoke the method and verify the result
        Operateur retrievedOperateur = operateurService.retrieveOperateur(operateurId);
        assertEquals(operateur, retrievedOperateur);

        // Verify that findById method of operateurRepository was called once with the correct argument
        verify(operateurRepository, times(1)).findById(operateurId);
    }
}