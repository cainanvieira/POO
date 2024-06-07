package fatecfranca.edu.livrariatrabalho.service;

import fatecfranca.edu.livrariatrabalho.model.dto.EditoraDTO;
import fatecfranca.edu.livrariatrabalho.model.dto.LivrariaDTO;
import fatecfranca.edu.livrariatrabalho.model.dto.LivroDTO;
import fatecfranca.edu.livrariatrabalho.model.entity.Editora;
import fatecfranca.edu.livrariatrabalho.model.entity.Livraria;
import fatecfranca.edu.livrariatrabalho.model.entity.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterClassesService {

    public LivrariaDTO converteLivrariaEntity(Livraria livraria){
        LivrariaDTO aux = new LivrariaDTO();
        aux.setTelefone(livraria.getTelefone());
        aux.setNome(livraria.getNome());
        aux.setCnpj(livraria.getCnpj());
        aux.setEndereco(livraria.getEndereco());
        aux.setLivros(converteLivroEntities(livraria.getLivros()));
        return aux;
    }

    public Livraria converteLivrariaDTO(LivrariaDTO livrariaDTO){
        Livraria aux = new Livraria();
        aux.setTelefone(livrariaDTO.getTelefone());
        aux.setNome(livrariaDTO.getNome());
        aux.setCnpj(livrariaDTO.getCnpj());
        aux.setEndereco(livrariaDTO.getEndereco());
        aux.setLivros(converteLivroDTOs(livrariaDTO.getLivros()));
        return aux;
    }

    public EditoraDTO converteEditoraEntity(Editora editora){
        EditoraDTO aux = new EditoraDTO();
        aux.setCnpj(editora.getTelefone());
        aux.setNome(editora.getNome());
        aux.setCnpj(editora.getCnpj());
        aux.setEndereco(editora.getEndereco());
        aux.setEmail(editora.getEmail());
        aux.setLivros(converteLivroEntities(editora.getLivros()));
        return aux;
    }

    public Editora converteEditoraDTO(EditoraDTO editoraDTO){
        Editora aux = new Editora();
        aux.setTelefone(editoraDTO.getTelefone());
        aux.setNome(editoraDTO.getNome());
        aux.setCnpj(editoraDTO.getCnpj());
        aux.setEndereco(editoraDTO.getEndereco());
        aux.setEmail(editoraDTO.getEmail());
        aux.setLivros(converteLivroDTOs(editoraDTO.getLivros()));
        return aux;
    }


    // converte LivroDTO para Livro
    public Livro converteLivroDTO(LivroDTO livroDTO){
        Livro aux =  new Livro();
        aux.setId(livroDTO.getId());
        aux.setNome(livroDTO.getNome());
        aux.setAutor(livroDTO.getAutor());
        aux.setQtde(livroDTO.getQtde());
        aux.setPreco(livroDTO.getPreco());
        aux.setLivraria(converteLivrariaDTO(livroDTO.getLivraria()));
        aux.setEditora(converteEditoraDTO(livroDTO.getEditora()));
        return aux;
    }

    // converte Livro para LivroDTO
    public LivroDTO converteLivroEntity(Livro livro){
        LivroDTO aux = new LivroDTO();
        aux.setId(livro.getId());
        aux.setNome(livro.getNome());
        aux.setAutor(livro.getAutor());
        aux.setQtde(livro.getQtde());
        aux.setPreco(livro.getPreco());
        aux.setLivraria(converteLivrariaEntity(livro.getLivraria()));
        aux.setEditora(converteEditoraEntity(livro.getEditora()));
        return aux;
    }
    public List<LivroDTO> converteLivroEntities(List<Livro> livros){
        // cria vetor de LivroDTO
        List<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();
        for (Livro livro : livros) { // para cada livro entity
            // converte entity em DTO e adiciono no vetor livrosDTD
            livrosDTO.add(converteLivroEntity(livro));
        }
        return livrosDTO;
    }

    public List<Livro> converteLivroDTOs(List<LivroDTO> livrosDTO){
        // cria vetor de Livro
        List<Livro> livros = new ArrayList<Livro>();
        for (LivroDTO livroDTO : livrosDTO) { // para cada livro DTO
            // converte DTO em Entity e adiciono no vetor livro entity
            livros.add(converteLivroDTO(livroDTO));
        }
        return livros;
    }
}
