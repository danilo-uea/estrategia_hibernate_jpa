import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class JPAUtil {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("estrategia");
        EntityManager em = emf.createEntityManager();

        Aluno aluno = new Aluno();
        aluno.setNome("dodo");
        aluno.setDataNascimento(LocalDate.of(1990, 10, 11));
        aluno.setEmail("dodo@gmail.com");

        //Apenas salva o aluno
        //em.getTransaction().begin(); // Contexto transacional do DB (ACID)
        //em.persist(aluno); //Salvar aluno
        //em.getTransaction().commit();

        //Encontrar aluno
        //Aluno alunoRecuperado = em.find(Aluno.class, 1);
        //System.out.println(alunoRecuperado.getNome());

        //Atualizar aluno
        //Aluno alunoRecuperado = em.find(Aluno.class, 1);
        //em.getTransaction().begin();
        //alunoRecuperado.setNome("rafa alterado");
        //em.getTransaction().commit();

        //Remover aluno
        //em.getTransaction().begin();
        //em.remove(em.find(Aluno.class, 1));
        //em.getTransaction().commit();

        // Linguagem JPQL = é uma forma de se fazer query em objetos utilizando strings (não é SQL)
        //List<Aluno> alunos = em.createQuery("select a from Aluno a").getResultList();
        //List<Aluno> alunos = em.createQuery("select a from Aluno a where a.nome like :code")
                //.setParameter("code", "d%")
                //.getResultList();
        //List<Aluno> alunos = em.createQuery("select a from Aluno a where a.id > :id")
                //.setParameter("id", 3)
                //.getResultList();
        //alunos.forEach(System.out::println);

        //Criteria = uma forma de se fazer query em objetos utilizando objetos
        //JPQL = uma forma de se fazer query em objetos utilizando strings

        //Estado Managed/Gerenciado = qualquer modificação ele já reflete no DB
        //em.getTransaction().begin();
        //em.persist(aluno); //Ele já salva o aluno no DB e entra no estado Managed
        //aluno.setNome("rafa alterado"); //Ele já faz o UPDATE no DB, pois está no estado Managed
        //em.getTransaction().commit();
        //em.getTransaction().begin();
        //aluno.setEmail("alterado@gmail.com"); //A alteração continua refletindo no DB
        //em.getTransaction().commit();

        //Estado Detached = Não há mais sincronia com o DB, então não faz mais alterações no DB
        //Não é possível usar o persist() se entrar nesse estado
        //em.getTransaction().begin();
        //em.persist(aluno);
        //aluno.setNome("rafa alterado 1"); // Executa no DB
        //em.detach(aluno); // Estado Detached
        //aluno.setNome("rafa alterado 2"); // Não executa no DB
        //em.getTransaction().commit();

        //Merge = Retorna para o estado Gerenciado (Managed)
        //Salva a instância no DB se estiver no estado Transient e atualiza se não estiver no estado Transient
        //em.getTransaction().begin();
        //em.persist(aluno);
        //em.detach(aluno); //Estado Detached
        //aluno.setNome("rafa alterado 3");
        //em.merge(aluno); //Agora as alterações são refletidas no DB e retorna para o estado gerenciado
        //em.getTransaction().commit();

        //Verifica se está no estado gerenciado
        //em.getTransaction().begin();
        //em.persist(aluno);
        //System.out.println(em.contains(aluno)); //Retorna true, pois está no estado gerenciado
        //em.detach(aluno);
        //System.out.println(em.contains(aluno)); //Retorna false
        //em.merge(aluno);
        //System.out.println(em.contains(aluno)); //Continua retornando false, pois o merge cria uma nova instância
        //Aluno alunoTeste = em.merge(aluno); //AlunoTeste recebe a referência e mantém o aluno no estado que já estava
        //System.out.println(em.contains(alunoTeste)); //Agora retorna true
        //em.getTransaction().commit();

        em.close();
    }
}
