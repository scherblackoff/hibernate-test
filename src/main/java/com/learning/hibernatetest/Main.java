package com.learning.hibernatetest;

import com.learning.hibernatetest.model.MyProduct;
import com.learning.hibernatetest.model.Person;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
// Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
// Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();
        MyProduct product = new MyProduct(99L, "orange");
//        Person person = new Person("Ivan", "Ivanov");
// Открываем транзакцию
        em.getTransaction().begin();
// Create (сохраняем в базе данных, и благодаря этому сущность
// становится управляемой Hibernate и заносится в контекст постоянства)
        em.persist(product);
// Подтверждаем транзакцию
        em.getTransaction().commit();
        em.getTransaction().begin();
// Read (читаем сущность из базы данных по id)
        MyProduct anotherProduct = em.find(MyProduct.class, 1L);
        em.getTransaction().commit();
        anotherProduct.setTitle("pineapple");
        em.getTransaction().begin();
// Update
        em.merge(anotherProduct);
        em.getTransaction().commit();
    }
}