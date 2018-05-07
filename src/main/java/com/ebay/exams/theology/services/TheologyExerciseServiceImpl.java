package com.ebay.exams.theology.services;

import com.ebay.exams.theology.dao.ExerciseDao;
import com.ebay.exams.theology.model.Exercise;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class TheologyExerciseServiceImpl implements TheologyExerciseService {
    @Autowired
    @Setter
    private ExerciseDao dao;

    @Setter
    @Getter
    private int version;

    @PostConstruct
    public void init(){
        System.out.println("REPO***********");
    }

    @Override
    public List<Exercise> getRandom(int amount) {
        List<Exercise> all = dao.findAll();
        Collections.shuffle(all);
        return all.subList(0,amount);
    }
}
