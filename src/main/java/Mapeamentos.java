import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Mapeamentos {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("estrategia");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);

        Endereco endereco = new Endereco("Trav Canarana", 6, "Cidade Nova");
        em.getTransaction().begin();
        em.persist(endereco);
        em.getTransaction().commit();

        Aluno aluno = new Aluno("", "adsaf", LocalDate.of(1988, 3, 25), endereco);
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();

        em.close();
    }
}
