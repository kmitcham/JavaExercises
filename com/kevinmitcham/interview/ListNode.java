package com.kevinmitcham.interview;
public class ListNode{
		ListNode next;
		ListNode previous;
		String s;
		String key="";
		String value;
		ListNode( int val){
			this.value = ""+val;
		}
		ListNode(String str){
			this.s = str;
		}
		ListNode(String key, String value){
			this.key = key;
			this.value = value;
		}
	public String toString(){
		return key + ":"+value;
	}
}
