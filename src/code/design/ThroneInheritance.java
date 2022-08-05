package code.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=XZlH06iGvtg
//https://leetcode.com/problems/throne-inheritance/
public class ThroneInheritance {

    class Person{
        String name;
        boolean isDead;
        List<Person> children;
        Person(String name){
            this.name = name;
            this.isDead = false;
            this.children = new ArrayList<>();
        }
    }

    Map<Person,Person> pmap;
    Map<String,Person> smap;
    String kingName;
    public ThroneInheritance(String kingName) {
        pmap = new HashMap<>();
        smap = new HashMap<>();
        Person king = new Person(kingName);
        this.kingName = kingName;
        pmap.put(king,null);
        smap.put(kingName,king);
    }

    public void birth(String parentName, String childName) {
        Person parent = smap.get(parentName);
        Person child = new Person(childName);
        parent.children.add(child);
        pmap.put(child,parent);
        smap.put(childName,child);
    }

    public void death(String name) {
        Person person = smap.get(name);
        person.isDead = true;
        smap.put(name,person);
    }

    public List<String> getInheritanceOrder() {

        List<String> res = new ArrayList<>();
        Person king = smap.get(kingName);
        dfs(king,res);
        return res;
    }

    public void dfs(Person root,List<String> res){

        if(root==null){
            return;
        }

        if(!root.isDead)
            res.add(root.name);

        if(root.children.size()==0){
            return;
        }

        for(Person child:root.children){
            dfs(child,res);
        }
    }

    public static void main(String args[]){

        ThroneInheritance root = new ThroneInheritance("king");
        root.birth("king", "andy");
        root.birth("king", "bob");
        root.birth("king", "catherine");
        root.birth("andy", "matthew");
        root.birth("bob", "alex");
        root.birth("bob", "asha");

        List<String> list = root.getInheritanceOrder();
        for(String name:list){
            System.out.print(name+" ");
        }

        System.out.println("\nbob dead");
        root.death("bob");

        list = root.getInheritanceOrder();
        for(String name:list){
            System.out.print(name+" ");
        }
    }
}
