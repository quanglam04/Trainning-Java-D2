package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class HibernateExample {
    public static void main(String[] args) {
        // Tạo SessionFactory từ Hibernate 6
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Mở một session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
        	// Thêm mới 1 sinh viên vào DB
//            Student student = new Student("Nguyen Van A234324", "nguyenvana@example.com234234");
//            session.persist(student);
            
            // Cập nhật 1 sinh viên đã có trong DB
            Student detachedStudent = session.get(Student.class,1);
            detachedStudent.setId(1L);
            detachedStudent.setEmail("trinhquanglam2k4@gmail.com");
            detachedStudent.setName("Updated Name"); 
            session.merge(detachedStudent);
            System.out.println("Update thành công");
            

            // Commit transaction
            transaction.commit();
            // Xem thông tin 1 sinh viên có sẵn trong DB
//            Student detachedStudentView = session.get(Student.class,1);
//            System.out.println(detachedStudentView.toString());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}