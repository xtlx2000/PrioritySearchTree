/******************************************************************************
*                       Copyright (c) 2011 - 2012 by                          *
*                               Simon Pratt                                   *
*                         (All rights reserved)                               *
*******************************************************************************
*                                                                             *
* FILE:    InPlacePST.java                                                    *
*                                                                             *
* MODULE:  Priority Search Tree                                               *
*                                                                             *
* NOTES:   Data structure presented in "In-place Priority Search Tree         *
*          and its applications" by De, Maheshwari, Nandy, Smid in 2011.      *
*                                                                             *
******************************************************************************/

public class InPlacePST implements PrioritySearchTree {
    PSTPoint[] tree;

    public InPlacePST(PSTPoint[] points) {
	tree = points;
	inPlaceSort(0,tree.length);
	int n = tree.length;
	int h = (int)Math.floor(log2(n));
	int nodesAtLastLevel = n - (int)(Math.pow(2,h) -1);
    }

    private void inPlaceSort(int beginIndex, int endIndex) {
	bubbleSort(beginIndex,endIndex);
    }

    // worst case and average: O(n^2), could use heapsort for better performance
    private void bubbleSort(int beginIndex, int endIndex) {
	boolean swapped;
	do {
	    swapped = false;
	    for(int i = (beginIndex + 1); i < endIndex; i++) {
		if(tree[i-1].xGreaterThan(tree[i])) {
		    swap(i-1,i);
		    swapped = true;
		}
	    }
	} while(swapped);
    }
    private void swap(int i, int j) {
	PSTPoint temp;
	temp = tree[i];
	tree[i] = tree[j];
	tree[j] = temp;
    }
/******************************************************************************
* Utility                                                                     *
******************************************************************************/
    private void printArray() {
	for(int i = 0; i < tree.length; i++) System.out.print(tree[i] + " ");
	System.out.println();
    }
    // Gives the base-2 logarithm of a double
    private double log2(double x) {
	return Math.log(x) / Math.log(2);
    }

/******************************************************************************
*                                                                             *
* FUNCTION NAME: baseZeroIndex                                                *
*                                                                             *
* PURPOSE:       Converts the index of a base one array into the index        *
*                of a base zero array.                                        *
*                                                                             *
* PARAMETERS                                                                  *
*   Type/Name:   int/baseOneIndex                                             *
*   Description: The index of an array with base one.                         *
*                                                                             *
* RETURN:        The integer equivalent index in an array with base zero.     *
*                                                                             *
******************************************************************************/
    private static int baseZeroIndex(int baseOneIndex) {
	return baseOneIndex - 1;
    }

/******************************************************************************
* Testing                                                                     *
******************************************************************************/
    public static void main(String[] args) {
	System.out.println("Creating points...");
	int MAX_Y = 3;
	PSTPoint[] testPoints = new PSTPoint[2*MAX_Y];
	int count = 0;
	for(int i = -MAX_Y; i < MAX_Y ; i++) {
	    testPoints[count++] = new PSTPoint(i,i+MAX_Y);
	}
	System.out.println("Building PST with " + (2*MAX_Y) + " nodes...");
	InPlacePST ippst = new InPlacePST(testPoints);
    }

/******************************************************************************
* Stubs (for now)                                                             *
******************************************************************************/
    
    public java.util.ArrayList<PSTPoint> findAllPointsWithin(double minX,
						   double maxX,
						   double maxY)
	throws EmptyTreeException {
	return null;
    }
    public double minYinRange(double minX, double maxX, double maxY)
	throws NoPointsInRangeException {
	throw new NoPointsInRangeException();
    }
    public double minXinRange(double minX, double maxX, double maxY)
	throws NoPointsInRangeException {
	throw new NoPointsInRangeException();
    }
    public double maxXinRange(double minX, double maxX, double maxY)
	throws NoPointsInRangeException {
	throw new NoPointsInRangeException();
    }
    public double maxYinRange(double minX, double maxX, double maxY)
	throws NoPointsInRangeException {
	throw new NoPointsInRangeException();
    }
}