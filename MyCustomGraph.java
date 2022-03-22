/*
Zoraz Haseeb
12/10/2021
MyCustomGraph.java
Project 6
1st Semester
CMSC 256 -001
This program intakes a text file full of vertices and edges and runs methods to answer some questions about the graph
 */
package cmsc256;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCustomGraph<V> extends UnweightedGraph<V>{
    public MyCustomGraph(){
        super();
    }
    public MyCustomGraph(V[] vertices, int[][] edges){
        super(vertices,edges);
    }
    public MyCustomGraph(List<V> vertices, List<Edge> edges){
        super(vertices,edges);
    }
    public MyCustomGraph(List<Edge> edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }
    public MyCustomGraph(int[][] edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }

    public MyCustomGraph<V> readFile(String fileName) throws FileNotFoundException{
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            throw new FileNotFoundException();
        }

        int numberOfVertices = 0;
        try {
            numberOfVertices = Integer.parseInt(input.readLine());

        } catch (IOException e) {

        }
        ArrayList<String> listOfEdges = new ArrayList<>();
        for(int i = 0; i < numberOfVertices;i++){
            try{
                String line = input.readLine();
                String splitString [] = line.split(" ");
                for (int j = 0; j< splitString.length;j++){
                    listOfEdges.add((splitString[j]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            listOfEdges.add("D");
        }
        String line = "";
        for (String digit: listOfEdges) {
            line += digit;
        }

        String splitString [] = line.split("D");
        List<Edge> edges = new ArrayList<>();
        for(int i = 0;i< splitString.length;i++){
             int numberOfEdges =splitString[i].length() - 1;
             String verticesAndEdges = splitString[i];
             int origin = Integer.parseInt(String.valueOf(verticesAndEdges.charAt(0)));
             for(int j = 1; j < numberOfEdges + 1;j++){
                    Edge hey = new Edge(origin,Integer.parseInt(String.valueOf(verticesAndEdges.charAt(j))));
                     edges.add(hey);

             }
        }

        MyCustomGraph<V> newGraph = new MyCustomGraph<>(edges,numberOfVertices);
        newGraph.printEdges();
        return newGraph;
    }
    public Boolean isComplete(){
        int numberOfVertices = getVertices().size();
        int numberOfEdges = 0;
        for(int i = 0;i < numberOfVertices;i++ ){
            numberOfEdges += getDegree(i);

        }
        int realNumberOfEdges = numberOfEdges/2;
        int completeness = (numberOfVertices * (numberOfVertices -1 )) /2;
        if( realNumberOfEdges == completeness){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean areAdjacent(V v1, V v2){
        int index1 = getIndex(v1);
        int index2 = getIndex(v2);


        List<Integer> neighorsOfVertex = getNeighbors(index1);
        if(neighorsOfVertex.contains(index2)){
            return true;
        }

        return false;
    }
    public Boolean isConnected(){
        if(vertices.size() < 2){
            return false;
        }
        printEdges();
        dfs(0);
        if (dfs(0).getNumberOfVerticesFound() == getVertices().size())
            return true;
        return false;
    }
    public List<V> getShortestPath(V begin, V end){
        List<V> shortest = bfs(getIndex(begin)).getPath(getIndex(end));
        if(shortest.get(shortest.size() - 1)  == end){
            shortest = null;
        }
        if(begin == end){
            shortest = bfs(getIndex(begin)).getPath(getIndex(end));
        }
        if(shortest != null) {
            Collections.reverse(shortest);
        }
        bfs(getIndex(begin)).printPath(getIndex(end));
        bfs(getIndex(begin)).printTree();
        printEdges();

        return shortest;
    }
    public Boolean hasCycle(){
        if(bfs(0).getNumberOfVerticesFound() < 3){
            return false;
        }
        return true;
    }
    public static void main(String [] args){
        MyCustomGraph<Integer> myGraph= new MyCustomGraph<>();
       try{
           MyCustomGraph<Integer> graph1 = myGraph.readFile("test0.txt");
           myGraph = myGraph.readFile("test0.txt");

           myGraph.printEdges();
           System.out.println(myGraph.isComplete());
           System.out.println(myGraph.areAdjacent(0,1));
           System.out.println(myGraph.isConnected());
           List<Integer> list = myGraph.getShortestPath(0,4);
           System.out.println(list);

       }catch (Exception e){
           System.out.println("Something went wrong");
           e.printStackTrace();
       }



    }

}
