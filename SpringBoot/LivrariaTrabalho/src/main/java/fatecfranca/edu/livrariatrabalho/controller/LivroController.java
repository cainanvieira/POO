package fatecfranca.edu.livrariatrabalho.controller;

import fatecfranca.edu.livrariatrabalho.model.dto.LivroDTO;
import fatecfranca.edu.livrariatrabalho.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService injecao;

    @PostMapping()
    public LivroDTO createLivro(@RequestBody LivroDTO livroDTO){

        return injecao.createLivro(livroDTO);
    }

    @DeleteMapping("/{id}")
    public String removeLivro(@PathVariable Long id){

        return injecao.removeLivro(id);
    }

    @GetMapping
    public List<LivroDTO> listaLivros(){

        return injecao.listaLivros();
    }

    @GetMapping("/{id}")
    public LivroDTO listaLivros(@PathVariable Long id){
        return injecao.listaLivro(id);
    }

    @PutMapping
    public List<LivroDTO> aplicaDesconto(){
        return injecao.aplicaDesconto();
    }

    @PatchMapping("/{id}")
    public LivroDTO atualizaPorId(@PathVariable Long id, @RequestBody LivroDTO livroDto){
        return injecao.atualizaPorId(id, livroDto);
    }
}