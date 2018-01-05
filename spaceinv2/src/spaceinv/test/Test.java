package spaceinv.test;


import spaceinv.statics.Ground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Here you should write your logical game tests
 *
 * Right click and run ...
 */
public class Test {

    public static void main(String[] args) {
        new Test().test();
    }
    void test() {
        
       // TODO  intersection
        Ground ground = new Ground(0,50,50,50);
        TestShip ts = new TestShip();
        List<TestProjectile> tp = new ArrayList<>();


        TestProjectile t = new TestProjectile();
        t.setX(5);
        //t.setDx();



        for (TestProjectile p : tp) {
            if(ground.intersects(p))
                tp.remove(p);
        }

        List<String> str = Arrays.asList("sad","das","auto");
        str.add("papper");
        List<String> str2 = Collections.unmodifiableList(str);

        System.out.print(ground.intersects(null));

       // TODO  Test Factory
    }


}
