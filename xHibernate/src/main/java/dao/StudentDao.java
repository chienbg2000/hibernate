package dao;

import entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class StudentDao {
    public static List<StudentEntity> getAllStudent(){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        List<StudentEntity> list = null;
        try{
            String hql = "select s from StudentEntity s";
            Query<StudentEntity> query = session.createQuery(hql);
            list = query.getResultList();
            return list;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        session.close();
        factory.close();
        return list;
    }

    public static void insertStudent(StudentEntity studentEntity){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            session.persist(studentEntity);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

}
