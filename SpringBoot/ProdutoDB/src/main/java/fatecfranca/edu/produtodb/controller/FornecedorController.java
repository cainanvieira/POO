package fatecfranca.edu.produtodb.controller;

import fatecfranca.edu.produtodb.model.dto.FornecedorDTO;
import fatecfranca.edu.produtodb.model.dto.ProdutoDTO;
import fatecfranca.edu.produtodb.service.FornecedorService;
import fatecfranca.edu.produtodb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired // injeção de dependência
    FornecedorService injecao;

    @PostMapping()
    public FornecedorDTO createProduto(@RequestBody FornecedorDTO fornecedorDTO){
        // chama método sem instanciar um objeto
        return injecao.createFornecedor(fornecedorDTO);
    }
}