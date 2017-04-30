package com.goalin.spring.service;

import java.util.List;

import com.goalin.spring.dao.GoalDAO;
import com.goalin.spring.model.Goal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoalServiceImpl implements GoalService {
	
	private GoalDAO goalDAO;

	public void setGoalDAO(GoalDAO goalDAO) {
		this.goalDAO = goalDAO;
	}

	@Override
	@Transactional
	public void addGoal(Goal g) { this.goalDAO.addGoal(g); }

	@Override
	@Transactional
	public void updateGoal(Goal g) {
		this.goalDAO.updateGoal(g);
	}

	@Override
	@Transactional
	public List<Goal> listGoals() {
		return this.goalDAO.listGoals();
	}

	@Override
	@Transactional
	public Goal getGoalById(int id) {
		return this.goalDAO.getGoalById(id);
	}

	@Override
	@Transactional
	public void removeGoal(int id) {
		this.goalDAO.removeGoal(id);
	}

}
