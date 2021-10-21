package nicuwatch.controller;

import nicuwatch.entity.Report;
import nicuwatch.persistence.SessionFactoryProvider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class main {
    public static void main(String[] args) {
        dbTest();
    }

    public static void dbTest() {
        SessionFactory session = SessionFactoryProvider.getSessionFactory();
        Session sesh = session.openSession();
        Transaction tx = sesh.beginTransaction();
        Report report = new Report();
        report.setDocId("doctor");
        report.setTest("Leg SStuff");
        report.setResult("Its Fine");
        report.setNotes("I said its fine!");
        sesh.persist(report);
        tx.commit();
        session.close();
    }
}

