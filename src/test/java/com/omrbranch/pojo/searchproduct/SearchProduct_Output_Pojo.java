package com.omrbranch.pojo.searchproduct;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct_Output_Pojo {
	private int status;
    private String message;
    private ArrayList<ProductSearchData> data;
    private String currency;
}
