import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;



//This creates the Graph to use find the path
public class Graph
{
	private final HashMap<String, Integer> NamesMap;
	private final HashMap<Integer, String> IndexMap;
	private final LinkedList[] graph;
	
	//Constructor
	public Graph()
	{
		NamesMap = new HashMap<String, Integer>();
		IndexMap = new HashMap<Integer, String>();
		graph = new LinkedList[54202];
		for(int i = 0; i < graph.length; i++)
		{
			graph[i] = new LinkedList<>();
		}
	}


	public void addAllEdges(Set<Integer> set)
	{
		for(int index : set)
		{
			graph[index].addAll(set);
			Iterator<Integer> it = getNeighbors(index).iterator();
			while(it.hasNext())
			{
				int temp = it.next();
				if(temp == index)
				{
					removeEdge(index, temp);
				}
			}
		}
	}

	//Removes edge from the graph
	public boolean removeEdge(int pos, Object index)
	{
		if(pos < 0 || pos > graph.length)
		{
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		
		if(!graph[pos].contains(index))
		{
			throw new NullPointerException("Does not contain index " + index);
		}
		return graph[pos].remove(index);
	}

	

	//This checks if two actors are directly connected to each other.
	public boolean containsNeighborOfIndex(int actor1, int actor2)
	{
		return graph[actor1].contains(actor2);
	}


	//Method that gets the neighbors of vertex 'vertex' and appends it to a LinkedList.
	public LinkedList<Integer> getNeighbors(int vertex)
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		Iterator<Integer> it = graph[vertex].iterator();
		while(it.hasNext())
		{
			linkedList.add(it.next());
		}
		return linkedList;
	}
		

	//Adds names into the namesMap
	public void addToNamesMap(String name, int position)
	{
		NamesMap.put(name, position);
	}
	
	//Adds names into the indexMap
	public void addToIndexMap(int position, String name)
	{
		IndexMap.put(position, name);
	}
	
	//This gets the index of the name
	public int getIndex(String name)
	{
		if(!NamesMap.containsKey(name))
		{
			throw new NullPointerException(name + " not found in index.");
		}
		return NamesMap.get(name);
	}
	
	//Gets the name in that position
	public String getName(int pos)
	{
		if(!IndexMap.containsKey(pos))
		{
			throw new NullPointerException(pos + " not found.");
		}
		return IndexMap.get(pos);
	}
	
	//Checks if the name is in the Graph
	public boolean containsActor(String name)
	{
		return NamesMap.containsKey(name);
	}

	//Number of elements in the name map
	public int namemapElements()
	{
		return NamesMap.size();
	}
	

}
