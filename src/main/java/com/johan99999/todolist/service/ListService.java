package com.johan99999.todolist.service;

import com.johan99999.todolist.entity.TaskList;
import com.johan99999.todolist.model.AddNewList;
import com.johan99999.todolist.model.ListResponse;
import com.johan99999.todolist.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ListService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ValidationService validationService;

    public ListResponse add(AddNewList request) {
        validationService.validate(request);

        // Optionally check for existing task with the same list
        if (listRepository.existsByList(request.getList())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Task already exists");
        }

        TaskList list = new TaskList();
        list.setList(request.getList());
        list.setFinished(TaskList.Finished.NO);  // Set default finished status to NO
        list.setTimeCreated(LocalDateTime.now());
        listRepository.save(list);

        return toResponse(list);
    }

    private ListResponse toResponse(TaskList list) {
        return ListResponse.builder()
                .no(list.getNo())
                .list(list.getList())
                .finished(list.getFinished())
                .timeCreated(list.getTimeCreated())
                .build();
    }
}
