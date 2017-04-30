package com.goalin.spring;


import com.goalin.spring.model.Goal;
import com.goalin.spring.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/goal")
public class GoalController {
    private GoalService goalService;

    @Autowired(required=true)
    @Qualifier(value="goalService")
    public void setGoalService(GoalService gs){
        this.goalService = gs;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listGoals(Model model) {
        model.addAttribute("goal", new Goal());
        model.addAttribute("listGoals", this.goalService.listGoals());
        return "goal";
    }

    //For add and update goal both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addGoal(@ModelAttribute("goal") Goal g){
        if(g.getId() == 0){
            //new goal, add it
            this.goalService.addGoal(g);
        }else{
            //existing goal, call update
            this.goalService.updateGoal(g);
        }
        return "redirect:/goal";
    }

    @RequestMapping("/remove/{id}")
    public String removeGoal(@PathVariable("id") int id){

        this.goalService.removeGoal(id);
        return "redirect:/goal";
    }

    @RequestMapping("/edit/{id}")
    public String editGoal(@PathVariable("id") int id, Model model){
        model.addAttribute("goal", this.goalService.getGoalById(id));
        model.addAttribute("listGoals", this.goalService.listGoals());
        return "goal";
    }
}
