/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
public class NewHireItemReader extends AbstractItemReader {
    @Inject
    private JobContext jobCtx;
 
    private BufferedReader reader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        String filepath = jobCtx.getProperties().getProperty( "file" );
        reader = new BufferedReader(
                new InputStreamReader(
                this
                .getClass()
                .getClassLoader()
                .getResourceAsStream(filepath)));
    }

    @Override
    public String readItem() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(NewHireItemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
