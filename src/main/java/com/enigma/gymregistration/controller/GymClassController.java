package com.enigma.gymregistration.controller;

import com.enigma.gymregistration.constant.AppPath;
import com.enigma.gymregistration.model.request.GymClassRequest;
import com.enigma.gymregistration.model.response.AddClassResponse;
import com.enigma.gymregistration.model.response.CommonResponse;
import com.enigma.gymregistration.model.response.GymClassResponse;
import com.enigma.gymregistration.service.GymClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppPath.GYM_CLASS)
@RequiredArgsConstructor
public class GymClassController {
    private final GymClassService gymClassService;

    @PostMapping(AppPath.ADD_CLASS)
    public ResponseEntity<?> registerClass(@RequestBody GymClassRequest request) {
        AddClassResponse registerResponse = gymClassService.addClass(request);

        CommonResponse<AddClassResponse> response = CommonResponse.<AddClassResponse>builder()
                .message("Successfully add class")
                .statusCode(HttpStatus.CREATED.value())
                .data(registerResponse)
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping(AppPath.GET_BY_ID)
    public ResponseEntity<?> getClassById(@PathVariable String id){
        GymClassResponse gymClassResponse = gymClassService.findClassById(id);
        CommonResponse<GymClassResponse> response = CommonResponse.<GymClassResponse>builder()
                .message("Successfully retrieved class")
                .statusCode(HttpStatus.OK.value())
                .data(gymClassResponse)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllClass(){
        List<GymClassResponse> gymClassResponses = gymClassService.findAllClass();
        CommonResponse<List<GymClassResponse>> response = CommonResponse.<List<GymClassResponse>>builder()
                .message("Successfully retrieved all class")
                .statusCode(HttpStatus.OK.value())
                .data(gymClassResponses)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateClass(@RequestBody GymClassRequest request) {
        GymClassResponse gymClassResponse = gymClassService.updateClass(request);
        CommonResponse<GymClassResponse> response = CommonResponse.<GymClassResponse>builder()
                .message("Successfully update user")
                .statusCode(HttpStatus.OK.value())
                .data(gymClassResponse)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping(AppPath.GET_BY_ID)
    public ResponseEntity<?> deleteClassById(@PathVariable String id){
        GymClassResponse gymClassResponse = gymClassService.deleteClass(id);
        CommonResponse<GymClassResponse> response = CommonResponse.<GymClassResponse>builder()
                .message("Successfully delete class")
                .statusCode(HttpStatus.OK.value())
                .data(gymClassResponse)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
