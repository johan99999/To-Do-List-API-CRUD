package com.johan99999.todolist.model;

import com.johan99999.todolist.entity.TaskList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListResponse {

    private Integer no;

    private String list;

    private LocalDateTime timeCreated;

    private TaskList.Finished finished;

}
