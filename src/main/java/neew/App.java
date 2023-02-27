package neew;

import entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public  static void main(String [] args) {
        Session session = null;
        try {
            // Create Configuration
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Song.class);

            // Create Session Factory
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Initialize Session Object
            session = sessionFactory.openSession();

            Song song1 = new Song();

            song1.setId(2);
            song1.setSongName("Broken Angel");
            song1.setArtist("Akon");

            session.beginTransaction();

            // Here we have used
            // save() method of JPA
            session.save(song1);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
