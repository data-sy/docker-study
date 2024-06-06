package com.mmt.api.dto.AI;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InputInstance {
    private List<int[]> input;

//    public InputInstance() {
//        this.input = new ArrayList<>(); // 여기서 초기화
//    }
//    public void addInput(int[] inputArray) {
//        this.input.add(inputArray);
//    }
}
