/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.batch;

import com.example.entity.NewHire;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;


/**
 *
 * @author user
 */
@Named
public class NewHireItemProcessor implements ItemProcessor {

    SimpleDateFormat format = new SimpleDateFormat("M/dd/yy");

    @Override
    public NewHire processItem(Object t) {
        System.out.println("processItem: " + t);

        StringTokenizer tokens = new StringTokenizer((String) t, ",");

        String name = tokens.nextToken();
        String date;

        try {
            date = tokens.nextToken();
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            return null;
        }

        return new NewHire(name, date);
    }
}
