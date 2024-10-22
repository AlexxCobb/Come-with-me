package ru.practicum.controller.publics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.dto.comment.CommentDto;
import ru.practicum.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/comments")
public class PublicCommentController {

    private final EventService eventService;

    @GetMapping("event/{eventId}")
    public List<CommentDto> getCommentsByEventId(@PathVariable Long eventId) {
        log.info("Поступил GET-запрос на получение всех комментариев события с id = : {}", eventId);
        return eventService.getCommentsByEventId(eventId);
    }

    @GetMapping("/{commentId}")
    public CommentDto findCommentById(@PathVariable Long commentId) {
        log.info("Поступил GET-запрос на получение комментария c id: {}", commentId);
        return eventService.findCommentDtoById(commentId);
    }
}