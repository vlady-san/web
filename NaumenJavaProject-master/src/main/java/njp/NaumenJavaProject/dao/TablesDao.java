package njp.NaumenJavaProject.dao;

import njp.NaumenJavaProject.models.Tables;
import njp.NaumenJavaProject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TablesDao {

    public Tables findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Tables.class, id);

    }

    public List<Integer> findAllBooked(String data) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select t.numt from Tables t where (concat(substring(t.date, 1, 4), substring(t.date, 6, 2), substring(t.date, 9, 2))" +
              " = concat(substring(:data, 1, 4), substring(:data, 6, 2), substring(:data, 9, 2)))");
        query.setParameter("data", data);
        return        query.list();
    }

    public void save(Tables tables) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(tables);
        tx1.commit();
        session.close();
    }

    public void update(Tables tables) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(tables);
        tx1.commit();
        session.close();
    }

    public void delete(Tables tables) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(tables);
        tx1.commit();
        session.close();
    }
}
