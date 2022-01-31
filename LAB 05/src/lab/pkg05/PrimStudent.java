/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg05;

/**
 *
 * @author Hasib
 */
import java.util.*;

public class PrimStudent{
  int [][] graph; // contains the graph
  String [] states; // contains the names of the states
  int [] d; // contains the distance
  int [] p; // contains the parent
 
  // this array checks which vertices are done worked with
  int [] check;
  
  
  // constructor
  public PrimStudent(int [][] graph,String [] states){
    this.graph = graph;
    this.states = states;
    // TO DO
    // create the arrays d, p and check
    p = new int[states.length];
    d = new int[states.length];
check = new int[states.length];
    
  }
  
  // runPrim() is the method where you apply Prim's algorithm
  public void runPrim(){
   // for each vertex assing a large value as inifinity
   // assign -1 as null
    for(int i = 0;i<states.length;i++){
      d[i] = 5000;
      p[i] = -1;
    }
    // picking 0 as source
    d[0] = 0;
    
     // TO DO
     // run a loop for all vertices
     for(int u=0;u<states.length;u++){
       // TO DO
       // extract the unchecked vertex with minimum d 
       // use the minVertex() method written below
       
       int w = minVertex();
       //System.out.println(" Value of w"+w);
       for(int v=0;v<states.length;v++){
         // check for connections
         if(graph[w][v]!=0){
           // TO DO
           // check if v in the array -> use the check array
           if(check[v]==0){
             
             // if d[v] > w(u,v)then d[v] = w(u,v) and p[v] = u
             if(d[v]>graph[w][v]){
               p[v]=w;
              d[v]=graph[w][v];
             }
           }
         }
       }
     }
     print();
  }
  
  // picks the UNCHECKED vertex with minimum d
  // before returning the value check the vertex
  public int minVertex(){
    int vertex = -1; 
    // check for unchecked vertex
    for(int i = 0;i<states.length;i++){
      if (check[i]!=-1){
        // -1 denotes checked
        vertex = i;
        break;
      }
    }
    // finding the vertex with min d 
    int minVal = d[vertex];
    //int minVertex = d;
    if (vertex!=-1){
      for(int i = vertex+1;i<states.length;i++){
        if(check[i]!=-1 && d[i]<minVal){
          minVal = d[i];
          vertex = i;
        }
      }
    }
    // check the vertex
    check[vertex] = -1;
    return vertex;
  }
  
  public void print(){
     for (int row = 1;row<states.length;row++){
       System.out.println("("+states[row]+"->"+states[p[row]]+")");
       //String parent = states[p[row]];
      //System.out.println();
    }
  }
}