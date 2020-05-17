package com.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class PeopleIndexes {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            ArrayList<String> company = new ArrayList<>(favoriteCompanies.get(i));

            boolean flag = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (j == i) {
                    continue;
                }
                ArrayList<String> other = new ArrayList<>(favoriteCompanies.get(j));
                if(other.containsAll(company)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                res.add(i);
            }
        }
        return res;
    }
}