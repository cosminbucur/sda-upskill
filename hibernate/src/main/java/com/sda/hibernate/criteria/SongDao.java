package com.sda.hibernate.criteria;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SongDao {

    public void create(Song song) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Song findById(Long id) {
        Song result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Song> criteriaQuery = criteriaBuilder.createQuery(Song.class);
            Root<Song> root = criteriaQuery.from(Song.class);
            criteriaQuery.select(root)
                    .where(criteriaBuilder.equal(root.get("id"), id));

            TypedQuery<Song> query = session.createQuery(criteriaQuery);
            result = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
