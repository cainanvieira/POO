package fatecfranca.edu.livrariatrabalho.controller;

import fatecfranca.edu.livrariatrabalho.model.dto.EditoraDTO;
import fatecfranca.edu.livrariatrabalho.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    EditoraService injecao;

    @PostMapping()
    public EditoraDTO createEditora(@RequestBody EditoraDTO editoraDTO){
        // chama método sem instanciar um objeto
        return injecao.createEditora(editoraDTO);
    }
}
