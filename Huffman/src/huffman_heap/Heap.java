package huffman_heap;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap implements Comparator<Nod>
{	
	ArrayList<Nod> heap=new ArrayList<Nod>();
	Heap()
	{
		heap.add(0, null);
	}


	@Override
	public int compare(Nod o1, Nod o2) 
	{
		if(o1.getFrecvata()>o2.getFrecvata())return -1;
		else if(o1.getFrecvata()<o2.getFrecvata()) return 1;
		return 0;
	
	}

	public void Swap(int i,int j)
	{
		Nod aux=heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, aux);
	}

	public void Sift_Down_MaxHeap(int i)
	{
		int pmax=i, j;
		do
		{
			j=pmax;
			if((2*j)<=(heap.size()-1) && compare(heap.get(2*j), heap.get(pmax))==-1)pmax=2*j;
			if((2*j+1)<=(heap.size()-1) &&compare(heap.get(2*j+1), heap.get(pmax))==-1)pmax=2*j+1;
			Swap(j,pmax);
		}while(pmax!=j);
	}
	public void Percolate_MaxHeap(int i)
	{
		int pmax=i,j;
		do
		{
			j=pmax;
			if(j>1 && compare(heap.get(j/2),heap.get(pmax))==1)pmax=j/2;
			Swap(j, pmax);
		}while(pmax!=j);
	}
	public void MakeMaxHeap()
	{
		for(int i=(heap.size()-1)/2;i>=1;i--)
		{
			Sift_Down_MaxHeap(i);
		}
	}

	public void Sift_Down_MinHeap(int i)
	{
		int pmin=i, j;
		do
		{
			j=pmin;
			if((2*j)<=(heap.size()-1) && compare(heap.get(2*j), heap.get(pmin))==1)pmin=2*j;
			if((2*j+1)<=(heap.size()-1) &&compare(heap.get(2*j+1), heap.get(pmin))==1)pmin=2*j+1;
			Swap(j,pmin);
		}while(pmin!=j);
	}
	public void MakeMinHeap()
	{
		for(int i=(heap.size()-1)/2;i>=1;i--)
		{
			Sift_Down_MinHeap(i);
		}
	}

	public Nod FindMin()
	{
		return heap.get(1);
	}
	public void ExtractMin()
	{
		if(heap.size()==2)
		{
			heap.remove(heap.size()-1);
		}
		else{
		heap.set(1	, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		Sift_Down_MinHeap(1);}
	}
	public void InsertMinHeap(Nod v)
	{
		heap.add(v);
		int i=heap.size()-1;
		while(i>1 && compare(heap.get(i),heap.get(i/2))==1)
		{
			Swap(i, i/2);
			i=i/2;
		}
		
	}
	@Override
	public String toString() {
		return "Heap :\n " + heap + "\n";
	}

}
