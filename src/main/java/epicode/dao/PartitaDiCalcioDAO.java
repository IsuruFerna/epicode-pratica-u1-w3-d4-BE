package epicode.dao;

import epicode.entities.Event;
import epicode.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartitaDiCalcioDAO {

    private final EntityManager em;

    public PartitaDiCalcioDAO(EntityManager em) {
        this.em = em;
    }


    public void save(PartitaDiCalcio evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PartitaDiCalcio findById(long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
