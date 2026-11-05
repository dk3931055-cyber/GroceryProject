package com.omrbranch.pojo.produclist;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductList_Output_Pojo {
	private int status;
	private String message;
	private String currency;
	private ArrayList<ProductListData> data;
	private String banner;
	private int cart_count;
}
