package com.goalin.spring.dao;



import com.goalin.spring.model.Goal;

import java.util.List;

public interface GoalDAO {
    public void addGoal(Goal p);
    public void updateGoal(Goal p);
    public List<Goal> listGoals();
    public Goal getGoalById(int id);
    public void removeGoal(int id);
}
