package com.erkan.controller;

import com.erkan.model.Score;
import com.erkan.model.ScoreDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
public class BoardController {

    private static SortedSet<Score> scoreBoard
            = Collections.synchronizedSortedSet(new TreeSet());


    @PostMapping(value = "/postScore")
    public void postScore(ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setName(scoreDTO.getName());
        score.setScore(Integer.parseInt(scoreDTO.getScore()));
        //System.out.println(score);
        scoreBoard.add(score);
    }

    @PostMapping(value = "/clear")
    public void clear() {
        scoreBoard.clear();
    }

    @GetMapping(value = "/getBoard")
    public @ResponseBody
    List<ScoreDTO> getBoard() {
        return scoreBoard.stream().map(s -> new ScoreDTO(s.getName(), String.valueOf(s.getScore()))).limit(10).collect(Collectors.toList());
    }
}
