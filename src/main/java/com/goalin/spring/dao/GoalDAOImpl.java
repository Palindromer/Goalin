package com.goalin.spring.dao;


import com.goalin.spring.model.Goal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GoalDAOImpl implements GoalDAO {

    private static final Logger logger = LoggerFactory.getLogger(GoalDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addGoal(Goal g) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(g);
        logger.info("Goal saved successfully, Goal Details="+g);
    }

    @Override
    public void updateGoal(Goal g) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(g);
        logger.info("Goal updated successfully, Goal Details="+g);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Goal> listGoals() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Goal> GoalsList = session.createQuery("from Goal").list();
        for(Goal g : GoalsList){
            logger.info("Goal List::"+g);
        }
        return GoalsList;
    }

    @Override
    public Goal getGoalById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Goal g = (Goal) session.load(Goal.class, new Integer(id));
        logger.info("Goal loaded successfully, Goal details="+g);
        return g;
    }

    @Override
    public void removeGoal(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Goal g = (Goal) session.load(Goal.class, new Integer(id));
        if(g != null){
            session.delete(g);
        }
        logger.info("Goal deleted successfully, Goal details="+g);
    }
}
