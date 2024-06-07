package fatecfranca.edu.produtodb.service;

import fatecfranca.edu.produtodb.model.dto.FornecedorDTO;
import fatecfranca.edu.produtodb.model.dto.ProdutoDTO;
import fatecfranca.edu.produtodb.model.entity.Fornecedor;
import fatecfranca.edu.produtodb.model.entity.Produto;
import fatecfranca.edu.produtodb.model.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    @Autowired
    ConvertersService injecaoConverter;

    @Autowired
    FornecedorRepository injecaoFornecedor;

    public FornecedorDTO createFornecedor(FornecedorDTO fornecedorDTO){
        // converte DTO em Entity
        Fornecedor fornecedor = injecaoConverter.converteFornecedorDTO(fornecedorDTO);
        Fornecedor novoFornecedor = injecaoFornecedor.save(fornecedor);
        // converte novoProduto em novoProdutoDTO
        return injecaoConverter.converteFornecedorEntity(novoFornecedor);
    }
}
