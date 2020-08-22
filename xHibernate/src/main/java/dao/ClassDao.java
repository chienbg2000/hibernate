package dao;

import entity.ClasssEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class ClassDao {
    public static ClasssEntity getClass(String id){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        ClasssEntity cl = null;
        try{
            String hql = "select s from ClasssEntity s where id = :id";
            Query<ClasssEntity> query = session.createQuery(hql);
            query.setParameter("id",id);
            cl = query.getSingleResult();
            return cl;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        session.close();
        factory.close();
        return cl;
    }
}
