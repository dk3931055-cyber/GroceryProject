package com.omrbranch.pojo.addtocart;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartVariation {
    private int id;
    private int product_id;
    private String weight;
    private int unit_id;
    private int qty;
    private String price;
    private String special_price;
    private int max_qty;
    private String status;
    private String created_at;
    private String updated_at;
    private int cart_count;
    private int discount;
    private int is_available;
    private int is_favorite;
    private String specifications;
    private ArrayList<AddToCartOption> options;
    private String original_special_price;


}
