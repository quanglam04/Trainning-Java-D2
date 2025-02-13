package MainApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Util.HibernateUtil;


public class MainApp {

	public static void main(String[] args) {
        // Lấy SessionFactory từ HibernateUtil
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Mở một session để Hibernate khởi động và tạo bảng
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println(" Hibernate đã kết nối với PostgreSQL và tạo bảng thành công!");

        // Đóng session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

