package fatecfranca.edu.produtodb.controller;

import fatecfranca.edu.produtodb.model.dto.ProdutoDTO;
import fatecfranca.edu.produtodb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired // injeção de dependência
    ProdutoService injecao;

    @PostMapping()
    public ProdutoDTO createProduto(@RequestBody ProdutoDTO produtoDTO){
        // chama método sem instanciar um objeto
        return injecao.createProduto(produtoDTO);
    }

    @DeleteMapping("/{id}")
    public String removeProduto(@PathVariable Long id){

        return injecao.removeProduto(id);
    }

    @GetMapping
    public List<ProdutoDTO> listaProdutos(){

        return injecao.listaProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO listaProduto(@PathVariable Long id){
        return injecao.listaProduto(id);
    }

    @PutMapping // atualiza todos os produtos
    public List<ProdutoDTO> aplicaDesconto(){
        return injecao.aplicaDesconto();
    }

    @PatchMapping("/{id}")
    public ProdutoDTO atualizaPorId(@PathVariable Long id, @RequestBody ProdutoDTO produtoDto){
        return injecao.atualizaPorId(id, produtoDto);
    }
}