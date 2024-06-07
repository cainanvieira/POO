package fatecfranca.edu.livrariatrabalho.service;

import fatecfranca.edu.livrariatrabalho.model.dto.EditoraDTO;
import fatecfranca.edu.livrariatrabalho.model.entity.Editora;
import fatecfranca.edu.livrariatrabalho.model.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {
    @Autowired
    ConverterClassesService injecaoConverter;

    @Autowired
    EditoraRepository injecaoLivraria;

    public EditoraDTO createEditora(EditoraDTO editoraDTO){
        // converte DTO em Entity
        Editora editora = injecaoConverter.converteEditoraDTO(editoraDTO);
        Editora novaEditora = injecaoLivraria.save(editora);
        // converte novaEditora em novaEditoraDTO
        return injecaoConverter.converteEditoraEntity(novaEditora);
    }
}

