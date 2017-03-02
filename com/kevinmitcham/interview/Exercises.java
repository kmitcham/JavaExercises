package com.kevinmitcham.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Exercises {
	String translateBase(String value, int source, int destination){
		int base10 = convertToBase10(value, source);
		return convertToAltBase(base10, destination);
	}
	
	int convertToBase10(String value, int base){
		char[] asChar = value.toCharArray();
		int total = 0;
		boolean negative = false;
		int placeVal = 0;
		for (char c: asChar){
			if (c == '-'){
				negative = true;
			} else {
				int digit = convertDigit(c);
				total *= base;
				total += digit;
			}
		}
		if (negative){
			total *= -1;
		}
		return total;
	}
	int convertDigit(char c){
		try {
			return Integer.parseInt(""+c);		
		} catch (Exception e){
			// ignore
		}
		return c - 'A' +10;
	}
	String convertToAltBase(int value, int base){
		int times = 1;
		int remainder =-1;
		StringBuilder sb = new StringBuilder();
		while ( times != 0 ){
			times = value/base;
			remainder = value % base;
			sb.insert(0, remainder);
			value = times;
		}
		return sb.toString();
	}
	/** convert 'a' to 'd','d';  delete 'b'  over first 'size' positions*/
	char[] mangleChar(char[] a, int size){
		char[] temp = new char[size];
		for (int i=0; i < size; i++){
			temp[i] = a[i];
		}
		for (int i=0, j=0; i < size; i++){
			switch( a[i]){
				case 'a': a[j++] = 'd';a[j++] = 'd'; break;
				case 'b': break;
				default : a[j++] = temp[i];
			}
		}
		return a;
	}

	void p(String m){
		System.out.println(m);
	}
	LinkedList<Integer> mergeLists(LinkedList<Integer> a, LinkedList<Integer> b){
		LinkedList<Integer> merged = new LinkedList();
		while (a.peek() != null || b.peek() != null){
			if (a.peek() == null){
				merged.add(b.pop());
			} else if (b.peek() == null){
				merged.add(a.pop());
			} else if (a.peek().compareTo(b.peek()) < 0){
				merged.add(a.pop());
			} else {
				merged.add(b.pop());
			}
		}
		return merged;
		
	}

	ListNode reverseSection(ListNode first, int start, int finish){
		ListNode leftEdgeNode=null, firstNode=null, lastNode=null, rightEdgeNode=null, temp, current, previous;
		int position = 1;
		temp = first;
		while ( temp != null && position < (finish+1 )){
			if (position == start -1){
				leftEdgeNode = temp;
			}
			if (position == start){
				firstNode = temp;
			}
			if (position == finish){
				lastNode = temp;
			}
			if (position == finish){
				rightEdgeNode = temp.next;
			}
			temp = temp.next;
			position++;
		}
		current = firstNode;
		ListNode edge = rightEdgeNode;
		int safety = 0;
		while (true){
			// starting from the left, 
			// temp= current next
			// set the next to the edge
			// update edge to the current
			// update current to the saved
			temp =current.next;
			current.next = edge;
			edge = current;
			current = temp;
			if (current.next.equals(rightEdgeNode) || safety++ > 100){
				break;
			}
		}
		leftEdgeNode.next = current;
		current.next = edge;

		return first;
	}
	public boolean isTreeBalanced(BinaryTreeNode<Integer> root){
		if (root == null) return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null ){
			if (root.right.left != null || root.right.right != null)
				return false;
		}
		if (root.right == null ){
			if (root.left.left != null || root.left.right != null)
				return false;
		}
		return (isTreeBalanced(root.right) && isTreeBalanced(root.left));
	}
	public ListNode checkForLoops(ListNode first){
		ListNode slow=first, fast;
		int fastcount=1,slowcount=1;
		fast = first;
		while (fastcount < 10000 ){
			if (fast.next == null || fast.next.next == null){
				return null;
			} else {
				fast = fast.next;
				fastcount++;
				if (fast == slow){
					break;
				}
				fast = fast.next;
				fastcount++;
			}
			slow = slow.next;
			slowcount++;
		}
		// so now fast and slow are the same
		int loop = 0;
		while (true){
			fast = fast.next; 
			loop++;
			if (fast == slow) break;
		}
		// we know the length of the loop
		slow = first;
		fast = first;
		for (int i=0; i < 1000; i++){
			fast = fast.next;
			if (i >= loop){
				slow = slow.next;
			}
			if (fast == slow){
				return slow;
			}
		}
		return slow;
	}
	public static int bsearch(int t, int[] A) {
	    int L = 0, U = A.length - 1;
	    while (L <= U) {
	      int M = L + (U-L)/2;
	      if (A[M] < t) {
	        L = M + 1;
	      } else if (A[M] == t) {
	        return M;
	      } else {
	        U = M - 1;
	      }
	    }
	    return -1;
	  }
	public int bSearchFirst(int[] a, int val){
	// return the index of the first location of val in sorted array a
		int index = bsearch(val, a);
		if (index < 0)
			return index;
		while (a[index] == a[index-1]){
			index--;
		}
	    return index;
	}
	public static int floorRoot(int a){
		double guess = Math.sqrt(a);
		return (int)Math.floor(guess);
	}
	public static int kthLargest(Integer[] a, int k){
		if (a.length < k) return k-a.length;
		// brute force: sort and return index.
		// I don't actually need to sort the whole set, though.
		// seems like a heap problem, not a search problem?
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
		for (int i = 0; i< a.length; i++){
			maxHeap.add(a[i]);
			if (maxHeap.size() == k + 1) {
				maxHeap.remove();
			}
		}
		return maxHeap.peek();
	}
	public int closestMatchedEntries(ArrayList<String> l){
		int leastDistance = l.size()+1;
		HashMap<String, Integer> locations = new HashMap(l.size());
		for (int i=0; i < l.size(); i++){
			Integer x = locations.get(l.get(i));
			if (x != null){
				int distance = i - x;
				if (distance < leastDistance){
					leastDistance = distance;
				}
			}
			locations.put(l.get(i), i);
		}
		if (leastDistance > l.size())
			return -1;
		return leastDistance;
	}
	public ArrayList<Integer> intersectionOfArrays(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> union = new ArrayList<Integer>();
		int i =0,j =0;
		while (i< a.size() && j < b.size()){
			Integer A = a.get(i);
			Integer B = b.get(j);
			int cmp = A.compareTo(B);
			switch (cmp){
			case 0:
				union.add(A);
				i++;j++;
				break;
			case -1:
				i++;
				break;
			case 1:
				j++;
				break;
				default:
					System.out.println("how did you get here?");
			}
		}
		return union;
	}
}
