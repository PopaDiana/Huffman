package huffman_heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainPg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//aaaaaaa bbbbb ccccccccccccccccc dddddddddd eeeeeeeee ffff ggg hhhhhhhh iiiiiiiiiiiii
		
		Scanner citire=new Scanner(System.in);
		String text;
		int [] frecv=new int[256];
		
		System.out.println(" Introduceti textul ");
		text=citire.nextLine();
		Arrays.fill(frecv, 0);
		for(int i=0;i<text.length();i++)
			frecv[text.charAt(i)]++;
		
		//frecv lui sir[i] = frecv[sir[i]]
		
		Heap heap_huff=new Heap();
		ArrayList<Byte> b=new ArrayList<Byte>();
		int k=1;
		for(int i=97;i<122;i++)
		{
			if(frecv[i]>0 )
				{
				heap_huff.heap.add(k,new Nod((char)i,frecv[i],b));
				k++;
				}
		}
		
		System.out.println("Frecventa aparitiei fiecarui caracter :");
		for(int i=1;i<heap_huff.heap.size();i++)
		{
			System.out.println(heap_huff.heap.get(i).getValoare()+"   ----   "+heap_huff.heap.get(i).getFrecvata());
		}
		
		/*
		heap_huff.MakeMaxHeap();
		System.out.println("Max Heapul realizat : ");
		for(int i=1;i<heap_huff.heap.size();i++)
		{
			System.out.println(heap_huff.heap.get(i).getValoare()+"   ----   "+heap_huff.heap.get(i).getFrecvata());
		}
		 */
		
		heap_huff.MakeMinHeap();
		System.out.println("Min Heapul realizat : ");
		Afisare(heap_huff);
	
		
		System.out.println("Radacina grafului huffman : ");
		Nod rad=Huffman(heap_huff);
		System.out.println("----------------");
		System.out.println(rad);
		System.out.println("----------------");

		System.out.println("Codurile caracterelor sunt: ");
		int n=0;
		ArrayList<Byte> aux=new ArrayList<Byte>();
		FindCode(rad,aux,n);
	
	

	}

	public static void Afisare(Heap a)
	{
		for(int i=1;i<a.heap.size();i++)
		{
			System.out.println(a.heap.get(i).getValoare()+"   ----   "+a.heap.get(i).getFrecvata()+"   ----   "+a.heap.get(i).getCod());

		}
		System.out.println();
	}
	public static Nod Huffman(Heap c)
	{
		Nod left,right;
		ArrayList<Byte> b=new ArrayList<Byte>();
		
		do
		{
			left=c.FindMin();
			c.ExtractMin();
			right=c.FindMin();
			c.ExtractMin();
			Nod top=new Nod('*',left.getFrecvata()+right.getFrecvata(),b);
			top.setLeft(left);
			top.setRight(right);
			c.InsertMinHeap(top);
		}
		while(c.heap.size()>=3);
		return c.FindMin();
	}
	public static void FindCode(Nod rad, ArrayList< Byte> cod,int i)
	{
		if(rad.left!=null)
		{
			cod.add(i,(byte)0);
			FindCode(rad.left,cod,i+1);
			cod.remove(cod.size()-1);
		}
		if(rad.right!=null)
		{
			cod.add(i,(byte)1);
			FindCode(rad.right,cod,i+1);
			cod.remove(cod.size()-1);
		}
		if(rad.left==null && rad.right==null)
		{
			
			System.out.println(rad.getFrecvata()+"  ---  "+rad.getValoare()+"  ---  "+cod);
	

		}
	}
	
	
}
