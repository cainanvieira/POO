package fatecfranca.edu.livrariatrabalho.service;

import fatecfranca.edu.livrariatrabalho.model.dto.LivrariaDTO;
import fatecfranca.edu.livrariatrabalho.model.entity.Livraria;
import fatecfranca.edu.livrariatrabalho.model.repository.LivrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrariaService {
    @Autowired
    ConverterClassesService injecaoConverter;

    @Autowired
    LivrariaRepository injecaoLivraria;

        public LivrariaDTO createLivraria(LivrariaDTO livrariaDTO){
            // converte DTO em Entity
            Livraria livraria = injecaoConverter.converteLivrariaDTO(livrariaDTO);
            Livraria novaLivraria = injecaoLivraria.save(livraria);
            // converte novaLivraria em novaLivrariaDTO
            return injecaoConverter.converteLivrariaEntity(novaLivraria);
        }
}
