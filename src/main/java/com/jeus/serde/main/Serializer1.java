/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeus.serde.main;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.jeus.serde.entity.User;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeus
 */
public class Serializer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Kryo kryo = new Kryo();
            Output output = new Output(new FileOutputStream("/home/jeus/Project/Datis/Kafka/serializeTest.bin"));
            Date dt = new Date();
            List<String> phone = new ArrayList<String>();
            phone.add("0913333212");
            phone.add("0913333888");
            phone.add("091222883");

            List<Integer> rates = new ArrayList<>();
            rates.add(1);
            rates.add(2);
            rates.add(3);
            User user = new User("jeus", "Geek", 29, dt.getTime(), phone, rates);

            kryo.writeObject(output, user);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializer1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
