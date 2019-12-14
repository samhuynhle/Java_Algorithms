import java.util.*;

// this implemenation of the graph is adjacency list using a HashMap.
// The keys are the nodes and the values is linked list of neighbors

class Graph<T>
{
    // we are using a Hashmap ot store the edges in the graph
    private Map<T, List<T>> map = new HashMap<>();

    // this funciton adds a vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    // this funciton adds an edge between two vertices (source and destination)
    public void addEdge(T source, T destination, boolean bidirectional)
    {
        if(!map.containsKey(source))
        {
            addVertex(source);
        }
        if(!map.containsKey(destination))
        {
            addVertex(destination);
        }
        map.get(source).add(destination);
        if(bidirectional == true)
        {
            map.get(destination).add(source);
        }
    }

    // this function gets the count of the vertices in the graph
    public void getVertexCount()
    {
        System.out.println("The graph has " + map.keySet().size() + " vertices");
    }

    // this function gets the count of edges in the graph
    public void getEdgesCount()
    {
        int count = 0;
        for (T v : map.keySet())
        {
            count += map.get(v).size();
        }
        if (bidirectional == true)
        {
            count = count / 2;
        }
        System.out.println("The graph has " + count + "edges.");
    }

    // this function gives whether a vertex is present or not
    public void hasVertex(T s)
    {
        if(map.containsKey(s))
        {
            System.out.println(("The graph contains " + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    // this function gives whether an edge is present or not
    public void HasEdge(T s, T d)
    {
        if(map.get(s).contains(d))
        {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    // This prints out thea adjacency list of each vertex
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for(T v : map.keySet())
        {
            builder.append(v.toString() + ": ");
            for(T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}