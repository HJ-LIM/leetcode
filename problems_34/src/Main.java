import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.*;

/**
* spec
 * 지정된 path 에 값을 저장 return true
 * 이미 path 가 존재하거나, 상위 path 가 존재 하지 않을면 reutrn false
 *
 * get : 해당 path 값을 리턴, 패스가 존재 하지 않으면 -1
* */

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        System.out.println(fileSystem.createPath("/a" ,1) == true);
        System.out.println(fileSystem.get("/a") == 1);
        System.out.println(fileSystem.createPath("/leet" , 1) == true);
        System.out.println(fileSystem.createPath("/leet/code" , 2) == true);
        System.out.println(fileSystem.get("/leet/code") == 2);
        System.out.println(fileSystem.createPath("/c/d" , 1) == false);
        System.out.println(fileSystem.get("/c") == -1);
    }

}

class FileSystem extends Temp{
    public boolean createPath(String path , int value){

        StringBuilder sb = new StringBuilder();
        String[] names = path.split("/");

        int depth = names.length-1;
        for (int i = 1; i < names.length; i++) {
            String name = names[i];
            sb.append("/");
            sb.append(name);

            if(i == depth){
                temp.put(sb.toString() , value);
            }else{
                if(!temp.containsKey(sb.toString())){
                    return false;
                }
            }
        }

        return true;
    }

    public int get(String path){
        if(temp.containsKey(path)) return temp.get(path);
        return -1;
    }

}

abstract class Temp{
    Map<String , Integer> temp = new HashMap<>();
}