package com.jeus.serde.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.jeus.serde.entity.User;
import com.jeus.serde.main.Serializer1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeus
 */
public class BenchTest {

    private static final int INST_SIZE = 86;//byte
    private static final long NUM_RECORDS = 20000;

    public BenchTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private double megaBytePerSec(long time) {
        return ((double) time / 1000);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
    public void benchMarkSer() {
        System.out.println("START TEST");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_RECORDS; i++) {
            try {
                Kryo kryo = new Kryo();
                Output output = new Output(new FileOutputStream("/home/jeus/project/Datis/kryo_serde/test1/user" + i + ".bin"));
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
        long endTime = System.currentTimeMillis();
        System.out.println("Producer Performance [Num/sec write]: " + NUM_RECORDS + "/" + megaBytePerSec(endTime - startTime));
        assertTrue(true);
    }

    @Test
    public void benchMarkDeser() {
        System.out.println("START TEST");
        long startTime = System.currentTimeMillis();
        User user = new User();
        for (int i = 0; i < NUM_RECORDS; i++) {
            try {
                Kryo kryo = new Kryo();
                Input input = new Input(new FileInputStream("/home/jeus/project/Datis/kryo_serde/test1/user" + i + ".bin"));
                user = kryo.readObject(input, User.class);
                input.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Serializer1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println(user.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("Producer Performance [Num/sec write]: " + NUM_RECORDS + "/" + megaBytePerSec(endTime - startTime));
        assertTrue(true);
    }

}
