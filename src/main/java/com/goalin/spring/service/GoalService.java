package com.goalin.spring.service;

import java.util.List;

import com.goalin.spring.model.Goal;

public interface GoalService {

	public void addGoal(Goal p);
	public void updateGoal(Goal p);
	public List<Goal> listGoals();
	public Goal getGoalById(int id);
	public void removeGoal(int id);
	
}
