package com.example.didaktikapp.data;

import com.example.didaktikapp.model.Word;

import java.util.List;

public interface WordDataSource {

    List<? extends Object> getWords();

}
