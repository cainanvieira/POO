package fatecfranca.edu.produtodb.service;
import fatecfranca.edu.produtodb.model.dto.ProdutoDTO;
import fatecfranca.edu.produtodb.model.entity.Produto;
import fatecfranca.edu.produtodb.model.repository.FornecedorRepository;
import fatecfranca.edu.produtodb.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired // injeção de dependência
    ProdutoRepository injecao; // poderemos chamar os métodos sem instanciar um objeto
    @Autowired // injeção de dependência
    ConvertersService injecaoConverter;
    @Autowired
    FornecedorRepository injecao2;

    public ProdutoDTO createProduto(ProdutoDTO produtoDTO){
        // converte DTO em Entity
        Produto produto = injecaoConverter.converteProdutoDTO(produtoDTO);
        if (produto.getFornecedor() != null && produto.getFornecedor().getId() == null) {
            injecao2.save(produto.getFornecedor());
        }
        Produto novoProduto = injecao.save(produto);
        // converte novoProduto em novoProdutoDTO
        return injecaoConverter.converteProdutoEntity(novoProduto);
    }

    public String removeProduto(Long id){
        if (injecao.existsById(id)){ // verifica se o produto existe
            injecao.deleteById(id); // remove o produto
            return "Remoção com sucesso";
        }
        else {
            return "Produto não existe";
        }
    }

    // retorna uma lista de produtos
    public List<ProdutoDTO> listaProdutos(){

        return injecaoConverter.converteProdutoEntities(injecao.findAll());
    }

    // retorna um produto a partir de um id
    public ProdutoDTO listaProduto(Long id){
        if (injecao.existsById(id)){
            // pode retornar zero ou vários Produto
            Optional<Produto> aux = injecao.findById(id);
            if (aux.isPresent()){ // existe alguém no vetor?
                return injecaoConverter.converteProdutoEntity(aux.get());
            }
            else {
                return null; // não existe
            }
        }
        return null; // não existe
    }

    // operação com o verbo HTTP PUT - update sem a cláusula where
    // todos os produtos serão descontados 10% no valor deles
    public List<ProdutoDTO> aplicaDesconto(){
        // obter os produtos em memória
        List<Produto> produtos = injecao.findAll();
        // aplicar o desconto
        // percorre a lista de produtos
        for(Produto produto: produtos){
            produto.setPreco(produto.getPreco() * 0.90f);
        }
        injecao.saveAll(produtos); // altera o banco com os produtos em desconto
        return injecaoConverter.converteProdutoEntities(produtos);
    }

    public ProdutoDTO atualizaPorId(Long id, ProdutoDTO produtoDTO){
        // verifica se o produto existe
        if (injecao.existsById(id)) {
            // o save, além de inserir, também pode atualizar. Basta passar
            // um objeto contendo um id já existente
            produtoDTO.setId(id);
            Produto prodAtualizado = injecao.save(injecaoConverter.converteProdutoDTO(produtoDTO));
            return injecaoConverter.converteProdutoEntity(prodAtualizado);
        }
        else {
            return null;
        }

    }

}