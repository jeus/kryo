/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeus.serde.main;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.jeus.serde.entity.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeus
 */
public class Deserializer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kryo kryo = new Kryo();

        try {
            Input input = new Input(new FileInputStream("/home/jeus/Project/Datis/Kafka/serializeTest.bin"));
            User user = kryo.readObject(input, User.class);
            System.out.println(user.toString());
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Deserializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
