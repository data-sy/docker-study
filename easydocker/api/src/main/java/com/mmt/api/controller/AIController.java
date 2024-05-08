package com.mmt.api.controller;

import com.mmt.api.dto.AI.AIInputResponse;
import com.mmt.api.dto.AI.AIOutputRequest;
import com.mmt.api.service.AnswerService;
import com.mmt.api.service.ProbabilityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
public class AIController {

    // 깃허브 액션 ECR 테스트 
    // IAM 정책 추가 후 테스트
    // 헛... yml 확장자가 안 붙어서 그런거였어 ㅋㅋ
    // 그래도 run에서 에러가 나서 cd easydocker/api를 붙여봄 
    // 사용자 생성 후 거기서 액세스 키 발급 받기
    // 아! 리전이 버지니아 북부로 되어 있었어 (여기서는 코드를 버지니아 북부로 하고, 실제 플젝에서는 서울로 가자)
    // 워크플로우 수정 

    private final AnswerService answerService;
    private final ProbabilityService probabilityService;

    public AIController(AnswerService answerService, ProbabilityService probabilityService) {
        this.answerService = answerService;
        this.probabilityService = probabilityService;
    }

    /**
     * AI input 데이터 플라스크에 제공
     */
    @GetMapping("/{userTestId}")
    public AIInputResponse getAIInput(@PathVariable Long userTestId){
        return answerService.findAIInput(userTestId);
    }

    /**
     * AI output 데이터 DB에 저장
     */
    @PostMapping("")
    public void create(@RequestBody AIOutputRequest request){
        probabilityService.create(request.getUserTestId(), request.getProbabilityList());
    }

}
