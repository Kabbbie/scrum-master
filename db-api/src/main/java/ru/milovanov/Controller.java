package ru.milovanov;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.milovanov.dao.CommentaryDao;
import ru.milovanov.jdo.Commentary;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final CommentaryDao commentaryDao;

    @GetMapping("/find")
    public Optional<Commentary> find(@RequestParam("id") String id) {
        return commentaryDao.findById(id);
    }

    @GetMapping ("/save")
    public String save(@RequestParam("id") String id) {
        Commentary commentary = commentaryDao.save(Commentary.builder()
                .id(id)
                .commentMessage("some")
                .creationTime(LocalDateTime.now())
                .build());
        return commentary.getId();
    }
}
