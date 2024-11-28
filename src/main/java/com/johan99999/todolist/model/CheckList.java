package com.johan99999.todolist.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckList {

    private int no;

    public enum Finished{
        YES, NO
    }
}
