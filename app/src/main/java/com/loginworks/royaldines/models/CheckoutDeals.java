package com.loginworks.royaldines.models;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ujjwal on 4/24/2017.
 */

public class CheckoutDeals {

    private String dealId;
    private String dealName;
    private String coupanCode;
    private String dealDiscount;
    private String dealCategoryId;
    private String dealType;
    private int status = 0;
    private ArrayList<CheckoutDeals> checkoutDealses;
    private ArrayList<String> coupanCodeList;

    public CheckoutDeals(String dealId, String dealName, String coupanCode, String dealDiscount, String dealCategoryId, String dealType) {
        this.dealId = dealId;
        this.dealName = dealName;
        this.coupanCode = coupanCode;
        this.dealDiscount = dealDiscount;
        this.dealCategoryId = dealCategoryId;
        this.dealType = dealType;
    }

    public CheckoutDeals(String coupanCode, String dealCategoryId) {
        this.coupanCode = coupanCode;
        this.dealCategoryId = dealCategoryId;
    }

    public CheckoutDeals(JSONObject jsonObject) {

        checkoutDealses = new ArrayList<>();
        coupanCodeList = new ArrayList<>();

        try {
            status = jsonObject.getInt("status");
            if (status == 1) {
                if (jsonObject.getJSONArray("deals").length() > 0) {
                    for (int i = 0; i < jsonObject.getJSONArray("deals").length(); i++) {
                        JSONObject object = jsonObject.getJSONArray("deals").getJSONObject(i);
                        CheckoutDeals checkoutDeals = new CheckoutDeals(object.getString("id"),
                                object.getString("name"), object.getString("coupon_code"),
                                object.getString("discount"), object.getString("category_id"),
                                object.getString("deal_type"));

                        checkoutDealses.add(checkoutDeals);
                        coupanCodeList.add(object.getString("coupon_code").toUpperCase());

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getCoupanCodeList() {
        return coupanCodeList;
    }

    public void setCoupanCodeList(ArrayList<String> coupanCodeList) {
        this.coupanCodeList = coupanCodeList;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getCoupanCode() {
        return coupanCode;
    }

    public void setCoupanCode(String coupanCode) {
        this.coupanCode = coupanCode;
    }

    public String getDealDiscount() {
        return dealDiscount;
    }

    public void setDealDiscount(String dealDiscount) {
        this.dealDiscount = dealDiscount;
    }

    public String getDealCategoryId() {
        return dealCategoryId;
    }

    public void setDealCategoryId(String dealCategoryId) {
        this.dealCategoryId = dealCategoryId;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<CheckoutDeals> getCheckoutDealses() {
        return checkoutDealses;
    }

    public void setCheckoutDealses(ArrayList<CheckoutDeals> checkoutDealses) {
        this.checkoutDealses = checkoutDealses;
    }

}
