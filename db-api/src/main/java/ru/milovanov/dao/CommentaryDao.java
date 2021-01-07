package ru.milovanov.dao;

import org.springframework.data.repository.CrudRepository;
import ru.milovanov.jdo.Commentary;

public interface CommentaryDao extends CrudRepository<Commentary, String> {
}
