package com.johan99999.todolist.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johan99999.todolist.model.AddNewList;
import com.johan99999.todolist.model.ApiResponse;
import com.johan99999.todolist.model.ListResponse;
import com.johan99999.todolist.repository.ListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void addNewTask() throws Exception {

        AddNewList request = new AddNewList();
        request.setList("Pergi Latihan Tinju Malam Besok");



        mockMvc.perform(
                post("/api/list/")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            ApiResponse<ListResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response);
            assertNull(response.getErrors());
        });
    }
}