package huffman_heap;

import java.util.ArrayList;

public class Nod 
{
	Nod left=null,right=null;
	
	int frecvata;
	char valoare;
	ArrayList<Byte> cod=new ArrayList<Byte>();
	public Nod( char valoare,int frecvata, ArrayList<Byte> cod) 
	{
		this.frecvata = frecvata;
		this.valoare = valoare;
		this.cod=cod;
	}
	
	public int getFrecvata() {
		return frecvata;
	}
	
	public void setFrecvata(int frecvata) {
		this.frecvata = frecvata;
	}
	
	public char getValoare() {
		return valoare;
	}
	
	public void setValoare(char valoare) {
		this.valoare = valoare;
	}
	
	public ArrayList<Byte> getCod() {
		return cod;
	}
	
	public void setCod(ArrayList<Byte> cod) {
		this.cod.addAll(cod);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [  frecvata=  " + frecvata + "  ,  valoare=  " + valoare + "  ,  cod=  " + cod + "  ]";
	}
	/**
	 * @return the left
	 */
	public Nod getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Nod left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Nod getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Nod right) {
		this.right = right;
	}

	
}
