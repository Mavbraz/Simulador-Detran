package com.github.mavbraz.hibernate;

import com.github.mavbraz.hibernate.basic.Category;
import com.github.mavbraz.hibernate.basic.Question;
import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DetranFactory {

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<Question> questions = null;

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            questions = session.createQuery("FROM Question").list();
        } catch (HibernateException e) {
        }

        return questions;
    }

    @SuppressWarnings("unchecked")
    public List<Question> getQuestionsByCategory(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<Question> questions = null;

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Question WHERE category = :category");
            query.setParameter("category", category);

            questions = query.list();
        } catch (HibernateException e) {
        }

        return questions;
    }

    @SuppressWarnings("unchecked")
    public List<Question> getQuestionsByQuestion(String question) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<Question> questions = null;

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Question WHERE question LIKE :question");
            query.setParameter("question", "%" + question + "%");

            questions = query.list();
        } catch (HibernateException e) {
        }

        return questions;
    }

    public Question getQuestion(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Question question = null;

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //question = (Question) session.load(Question.class, id);
            Query query = session.createQuery("FROM Question WHERE id = :id");
            query.setParameter("id", id);

            question = (Question) query.uniqueResult();
        } catch (HibernateException e) {
        }

        return question;
    }

    public List<Question> getRandomQuestions(int number) {
        List<Question> questions = getAllQuestions();
        Collections.shuffle(questions);
        Collections.shuffle(questions);
        Collections.shuffle(questions);

        return questions.subList(0, number);
    }

}
