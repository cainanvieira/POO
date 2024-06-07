package fatecfranca.edu.livrariatrabalho.service;

import fatecfranca.edu.livrariatrabalho.model.dto.LivroDTO;
import fatecfranca.edu.livrariatrabalho.model.entity.Livro;
import fatecfranca.edu.livrariatrabalho.model.repository.LivrariaRepository;
import fatecfranca.edu.livrariatrabalho.model.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired // injeção de dependência
    LivroRepository injecao; // poderemos chamar os métodos sem instanciar um objeto
    @Autowired // injeção de dependência
    ConverterClassesService injecaoConverter;
    @Autowired
    LivrariaRepository injecao2;

    public LivroDTO createLivro(LivroDTO livroDTO){
        // converte DTO em Entity
        Livro livro = injecaoConverter.converteLivroDTO(livroDTO);
        if (livro.getLivraria() != null && livro.getLivraria().getCnpj() == null) {
            injecao2.save(livro.getLivraria());
        }
        Livro novoLivro = injecao.save(livro);
        // converte novoLivro em novoLivroDTO
        return injecaoConverter.converteLivroEntity(novoLivro);
    }

    public String removeLivro(Long id){
        if (injecao.existsById(id)){ // verifica se o livro existe
            injecao.deleteById(id); // remove o livro
            return "Livro excluído";
        }
        else {
            return "O livro informado não existe";
        }
    }

    // retorna uma lista de livros
    public List<LivroDTO> listaLivros(){

        return injecaoConverter.converteLivroEntities(injecao.findAll());
    }

    // retorna um livro a partir de um id
    public LivroDTO listaLivro(Long id){
        if (injecao.existsById(id)){
            // pode retornar zero ou vários Livro
            Optional<Livro> aux = injecao.findById(id);
            if (aux.isPresent()){ // existe alguém no vetor?
                return injecaoConverter.converteLivroEntity(aux.get());
            }
            else {
                return null; // não existe
            }
        }
        return null; // não existe
    }

    // operação com o verbo HTTP PUT - update sem a cláusula where
    // todos os livros serão descontados 10% no valor deles
    public List<LivroDTO> aplicaDesconto() {
        List<Livro> livros = injecao.findAll();
        int count = 0;
        // Aplica o desconto de 50% de desconto no segundo livro
        for (Livro livro : livros) {
            if (count % 2 != 0) { // Verifica se é o segundo livro
                livro.setPreco(livro.getPreco() * 0.5f); // Aplica o desconto de 50%
            }
            count++;
        }
        injecao.saveAll(livros);
        return injecaoConverter.converteLivroEntities(livros);
    }

    public LivroDTO atualizaPorId(Long id, LivroDTO livroDTO){
        // verifica se o livro existe
        if (injecao.existsById(id)) {
            // o save, além de inserir, também pode atualizar. Basta passar
            // um objeto contendo um id já existente
            livroDTO.setId(id);
            Livro livroAtualizado = injecao.save(injecaoConverter.converteLivroDTO(livroDTO));
            return injecaoConverter.converteLivroEntity(livroAtualizado);
        }
        else {
            return null;
        }

    }
}
