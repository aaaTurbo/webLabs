package ru.aaaTurbo.dao;

import javax.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.aaaTurbo.entities.ReportEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public boolean save(ReportEntity report) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata mtd = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = mtd.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.createQuery("insert into ReportEntity(sessionId, time, hit, x, y, r)" +
                " values('" + report.getSessionId() + "', '" + report.getTime() +
                "', '" + report.getHit() + "', '" + report.getX() + "', '" +
                report.getY() + "', '" + report.getR() + "')");

        t.commit();
        factory.close();
        session.close();

        return true;
    }

    public ArrayList<ReportEntity> getReports(String sessionId) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata mtd = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = mtd.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        List<ReportEntity> items = session.createQuery("from ReportEntity where sessionId = '" + sessionId + "'").list();

        t.commit();

        ArrayList<ReportEntity> res = new ArrayList<>();

        items.forEach(res::add);

        factory.close();
        session.close();

        return res;
    }
}
