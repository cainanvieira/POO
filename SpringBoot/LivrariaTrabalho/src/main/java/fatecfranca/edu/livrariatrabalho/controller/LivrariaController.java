package fatecfranca.edu.livrariatrabalho.controller;

import fatecfranca.edu.livrariatrabalho.model.dto.LivrariaDTO;
import fatecfranca.edu.livrariatrabalho.service.LivrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/livraria")
public class LivrariaController {

    @Autowired
    LivrariaService injecao;

    @PostMapping()
    public LivrariaDTO createLivraria(@RequestBody LivrariaDTO livrariaDTO){
        // chama método sem instanciar um objeto
        return injecao.createLivraria(livrariaDTO);
    }
}
