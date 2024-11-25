package org.NAK.Citronix.Service.Implementation;


import org.NAK.Citronix.DTO.Tree.CreateTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;
import org.NAK.Citronix.DTO.Tree.UpdateTreeDTO;
import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Entity.Tree;
import org.NAK.Citronix.Mapper.TreeMapper;
import org.NAK.Citronix.Repository.FieldRepository;
import org.NAK.Citronix.Repository.TreeRepository;
import org.NAK.Citronix.Validation.TreeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TreeServiceImplTest {

    @InjectMocks
    private TreeServiceImpl treeService;

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private TreeValidator treeValidator;

    @Mock
    private TreeMapper treeMapper;

    private CreateTreeDTO createTreeDTO;
    private UpdateTreeDTO updateTreeDTO;
    private Tree tree;
    private Field field;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        createTreeDTO = new CreateTreeDTO();
        createTreeDTO.setFieldId(1L);

        updateTreeDTO = new UpdateTreeDTO();
        updateTreeDTO.setFieldId(1L);

        field = new Field();
        field.setId(1L);

        tree = new Tree();
        tree.setId(1L);
        tree.setPlaningDate(LocalDate.now().minusYears(5));
        tree.setField(field);

        when(fieldRepository.findById(any())).thenReturn(Optional.of(field));
        when(treeMapper.toTree(createTreeDTO)).thenReturn(tree);
        when(treeMapper.toTree(updateTreeDTO)).thenReturn(tree);
        when(treeRepository.save(any(Tree.class))).thenReturn(tree);
        when(treeMapper.toResponseTreeSharedDTO(tree)).thenReturn(new ResponseTreeSharedDTO());
        when(treeMapper.toResponseTreeDTO(tree)).thenReturn(new ResponseTreeDTO());
    }

    @Test
    void createTree() {
        ResponseTreeSharedDTO result = treeService.createTree(createTreeDTO);

        assertNotNull(result);
        verify(treeValidator).validateTreeRequest(tree);
        verify(treeValidator).validateFieldCapacity(field);
        verify(treeRepository).save(tree);
    }

    @Test
    void updateTree() {
        Long treeId = 1L;
        when(treeRepository.findById(treeId)).thenReturn(Optional.of(tree));

        ResponseTreeDTO result = treeService.updateTree(treeId, updateTreeDTO);

        assertNotNull(result);
        verify(treeValidator).validateTreeRequest(tree);
        verify(treeValidator).validateFieldCapacity(field);
        verify(treeRepository).save(tree);
    }

    @Test
    void getTree() {
        Long treeId = 1L;
        when(treeRepository.findById(treeId)).thenReturn(Optional.of(tree));

        ResponseTreeDTO result = treeService.getTree(treeId);

        assertNotNull(result);
        verify(treeRepository).findById(treeId);
    }

    @Test
    void deleteTree() {
        Long treeId = 1L;
        when(treeRepository.existsById(treeId)).thenReturn(true);

        assertDoesNotThrow(() -> treeService.deleteTree(treeId));

        verify(treeRepository).deleteByIdWithQuery(treeId);
    }

    @Test
    void getTrees() {
        when(treeRepository.findAll()).thenReturn(List.of(tree));

        List<ResponseTreeDTO> result = treeService.getTrees();

        assertNotNull(result);
        assertEquals(1, result.size());
    }


    @Test
    void calculateAge() {
        Long id = 1L;
        when(treeRepository.findById(id)).thenReturn(Optional.of(tree));

        double age = treeService.calculateAge(id);

        assertEquals(5, age);
    }
}