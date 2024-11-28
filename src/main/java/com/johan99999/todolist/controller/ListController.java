package com.johan99999.todolist.controller;

import com.johan99999.todolist.entity.TaskList;
import com.johan99999.todolist.model.AddNewList;
import com.johan99999.todolist.model.ApiResponse;
import com.johan99999.todolist.model.CheckList;
import com.johan99999.todolist.model.ListResponse;
import com.johan99999.todolist.repository.ListRepository;
import com.johan99999.todolist.service.ListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    @Autowired
    private ListService listService;

    @Autowired
    private ListRepository listRepository;

    @PostMapping(path = "/api/list/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ListResponse> add(@RequestBody AddNewList request) {
        ListResponse response = listService.add(request);
        return ApiResponse.<ListResponse>builder().data(response).build();
    }

    @PatchMapping(path = "/api/list/{no}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ListResponse> checkList(@PathVariable("no") int no, @RequestBody CheckList request) {
        request.setNo(no);

        ListResponse response = listService.checkList(request);
        return ApiResponse.<ListResponse>builder().data(response).build();
    }


}
