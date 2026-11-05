package com.omrbranch.pojo.getcategorylist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryList_Output_Pojo {
	private int status;
    private String message;
    private ArrayList<CategoryData> data;


}
