package fatecfranca.edu.produtodb.service;

import fatecfranca.edu.produtodb.model.dto.FornecedorDTO;
import fatecfranca.edu.produtodb.model.dto.ProdutoDTO;
import fatecfranca.edu.produtodb.model.entity.Fornecedor;
import fatecfranca.edu.produtodb.model.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertersService {

    public FornecedorDTO converteFornecedorEntity(Fornecedor fornecedor){
        FornecedorDTO aux = new FornecedorDTO();
        aux.setId(fornecedor.getId());
        aux.setNome(fornecedor.getNome());
        aux.setCnpj(fornecedor.getCnpj());
        aux.setEndereco(fornecedor.getEndereco());
        aux.setProdutos(converteProdutoEntities(fornecedor.getProdutos()));
        return aux;
    }

    public Fornecedor converteFornecedorDTO(FornecedorDTO fornecedorDTO){
        Fornecedor aux = new Fornecedor();
        aux.setId(fornecedorDTO.getId());
        aux.setNome(fornecedorDTO.getNome());
        aux.setCnpj(fornecedorDTO.getCnpj());
        aux.setEndereco(fornecedorDTO.getEndereco());
        aux.setProdutos(converteProdutoDTOs(fornecedorDTO.getProdutos()));
        return aux;
    }


    // converte ProdutoDTO para Produto
    public Produto converteProdutoDTO(ProdutoDTO produtoDTO){
        Produto aux =  new Produto();
        aux.setId(produtoDTO.getId());
        aux.setNome(produtoDTO.getNome());
        aux.setDescricao(produtoDTO.getDescricao());
        aux.setQtde(produtoDTO.getQtde());
        aux.setPreco(produtoDTO.getPreco());
        aux.setFornecedor(converteFornecedorDTO(produtoDTO.getFornecedor()));
        return aux;
    }

    // converte Produto para ProdutoDTO
    public ProdutoDTO converteProdutoEntity(Produto produto){
        ProdutoDTO aux = new ProdutoDTO();
        aux.setId(produto.getId());
        aux.setNome(produto.getNome());
        aux.setDescricao(produto.getDescricao());
        aux.setQtde(produto.getQtde());
        aux.setPreco(produto.getPreco());
        aux.setFornecedor(converteFornecedorEntity(produto.getFornecedor()));
        return aux;
    }
    public List<ProdutoDTO> converteProdutoEntities(List<Produto> produtos){
        // cria vetor de ProdutoDTO
        List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
        for (Produto produto : produtos) { // para cada produto entity
            // converte entity em DTO e adiciono no vetor produtosDTD
            produtosDTO.add(converteProdutoEntity(produto));
        }
        return produtosDTO;
    }

    public List<Produto> converteProdutoDTOs(List<ProdutoDTO> produtosDTO){
        // cria vetor de Produto
        List<Produto> produtos = new ArrayList<Produto>();
        for (ProdutoDTO produtoDTO : produtosDTO) { // para cada produto DTO
            // converte DTO em Entity e adiciono no vetor produto entity
            produtos.add(converteProdutoDTO(produtoDTO));
        }
        return produtos;
    }
}