package fatecfranca.edu.livrariatrabalho.model.dto;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class LivroDTO {
    private Long id;
    private String nome, autor;
    private int qtde;
    private float preco;
    private LivrariaDTO livraria;
    private EditoraDTO editora;

    public LivroDTO(Long id, String nome, String autor, int qtde, float preco, LivrariaDTO livrariaDTO) {
    }
}