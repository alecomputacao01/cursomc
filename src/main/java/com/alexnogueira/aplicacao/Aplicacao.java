/* package com.alexnogueira.aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alexnogueira.cursomc.domain.Pessoa;

public class Aplicacao {

public static void main(String[] args) {
    
    //Pessoa p1 = new Pessoa(null,"Alex", "alex@teste.com");
    //Pessoa p2 = new Pessoa(null,"Joao", "joao@teste.com");
    //Pessoa p3 = new Pessoa(null,"Jose", "jose@teste.com");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

    EntityManager em = emf.createEntityManager();
    //em.getTransaction().begin();

    //em.persist(p1);
    //em.persist(p2);
    //em.persist(p3);

    //em.getTransaction().commit();
    
    Pessoa p = em.find(Pessoa.class, 2);
    if (p.getId() == 2 ) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("Pessoa com id: " + p + "Removida");
    }
    
  //  System.out.println(p);
    
    
    System.out.println("pronto!");
    em.close();
    emf.close();
}

}
 */