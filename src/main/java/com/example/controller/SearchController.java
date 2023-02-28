package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeFilterDto;
import com.example.dto.profile.ProfileDTO;
import com.example.repository.EmployeeCustomRepository;
import com.example.repository.ProfileCustomRepository;
import com.example.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

@Autowired
private SearchService searchService;

    @GetMapping("/")

    public ResponseEntity<List<EmployeeDto>> myInfo(@RequestBody EmployeeFilterDto P,
                                                    @RequestParam Integer page,
                                                    @RequestParam Integer size){
        return ResponseEntity.ok(searchService.universalSearch(P,page,size));
    }
}
