package com.mmt.api.controller;

import com.mmt.api.dto.AI.AIInputResponse;
import com.mmt.api.dto.AI.AIOutputRequest;
import com.mmt.api.dto.AI.AIServingResponse;
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
    // 워크플로우 수정 (얘도 리전 설정 챙겨줘야 해. 3군데)
    // 태그는 latest로 통일해서 ECR 개수 1개로 유지 
    // 기존 코드로 다시 회귀
    // 다시 환경변수 버전으로 수정 . 들여쓰기 잘 맞춰야 해! : 도 빼야지~
    // 이미지 삭제 후에도 다시 생성 잘 되는지 확인
    // $를 빼먹었었어 
    // 새로 배포할 때 기존 이미지 삭제 안 되는지 확인
    // 삭제 정책 테스트 1
    // 삭제 정책 테스트 2
    // 리전 서울로 레포 새로 팜

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

    /**
     * 텐서플로우_서빙 서버 테스트
     */
    @GetMapping("/serving-test-test")
    public AIServingResponse getPrediction(){
        return probabilityService.getPrediction();
    }

}
