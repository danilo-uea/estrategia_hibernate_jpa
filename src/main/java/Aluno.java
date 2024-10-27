import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity //Mapeamento de classes. O Hibernate cria uma tabela correspondente no banco de dados (caso ela ainda não exista).
//@Table(name="tb-aluno") //Mudar o nome da tabela no DB
public class Aluno {
    @Id //Chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) //Deve ser gerado automaticamento pelo DB
    private Integer id;
    @NotNull //Beans Validation
    @NotEmpty //Beans Validation
    private String nome;
    @Email //Beans Validation
    private String email;
    @Past //Beans Validation //Deve ser anterior a data atual
    private LocalDate dataNascimento;
    //@Column(name = "atualizar", length = 11) //Muda o nome da coluna e define o tamanho para 11 no DB
    private LocalDateTime updated;
    @Transient //Não cria campo no DB
    private String apelido;
    @ManyToMany
    private List<Curso> cursos = new ArrayList<>();
    @OneToOne
    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(String nome, String email, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public String getApelido() {
        return apelido;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", updated=" + updated +
                '}';
    }
}
