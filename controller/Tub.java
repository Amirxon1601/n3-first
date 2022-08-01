package uz.nt.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.nt.firstspring.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Tub {
    private List<Integer> list = new ArrayList<>();

    @GetMapping("/tub2")
    public List<Integer> tub(@RequestParam Integer n) {
        for (int i = 1; i < n; i++){
          if(prime(i)){
              list.add(i);
          }

        }
        return list;
    }

    private boolean prime(Integer a){
        if (a == 1){
            return false;
        }
        for (int j = 2; j < a; j++){
            if (a % j == 0) {
                return false;
                }
            }
        return true;
        }
    }