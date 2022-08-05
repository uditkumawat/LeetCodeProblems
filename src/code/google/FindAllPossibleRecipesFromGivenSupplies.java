package code.google;

import java.util.*;

//https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
//topological sort
public class FindAllPossibleRecipesFromGivenSupplies {

    public static void main(String args[]){

        String recipes[] = {"bread"};
        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast","flour"));
        String supplies[] = {"yeast","flour","corn"};

        FindAllPossibleRecipesFromGivenSupplies obj = new FindAllPossibleRecipesFromGivenSupplies();

        List<String> res = obj.findAllRecipes(recipes,ingredients,supplies);

        for(String str:res){
            System.out.print(str+" ");
        }
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredientsList, String[] supplies) {

        Map<String,List<String>> mapping = new HashMap();

        Map<String,Integer> indegrees = new HashMap();

        Set<String> recipesSet = new HashSet();

        Set<String> suppliesSet = new HashSet();


        for(int i=0;i<recipes.length;i++){

            String recipe = recipes[i];

            recipesSet.add(recipe);

            List<String> ingredients = ingredientsList.get(i);

            for(String ingredient:ingredients){
                indegrees.put(recipe,indegrees.getOrDefault(recipe,0)+1);

                List<String> rcps = mapping.getOrDefault(ingredient,new ArrayList<>());
                rcps.add(recipe);

                mapping.put(ingredient,rcps);
            }
        }

        Queue<String> q = new LinkedList<>();

        for(String supply:supplies){
            suppliesSet.add(supply);
            q.add(supply);
        }

        List<String> res = new ArrayList<>();

        while(!q.isEmpty()){
            String ingredient = q.poll();

            if(recipesSet.contains(ingredient)){
                res.add(ingredient);
            }

            if(mapping.containsKey(ingredient)) {
                for (String child : mapping.get(ingredient)) {
                    indegrees.put(child, indegrees.getOrDefault(child, 0) - 1);
                    if (indegrees.get(child) == 0) {
                        q.add(child);
                    }
                }
            }
        }

        return res;
    }
}
