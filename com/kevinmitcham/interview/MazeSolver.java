package com.kevinmitcham.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MazeSolver {
	boolean debug = false;
	boolean canSolve(String[][] maze, Integer[] start, Integer[] finish){
		if (start.length != 2 || finish.length != 2){
			System.out.println("Bad start or finish");
			return false;
		}
		HashMap<String, Integer[]> visited = new HashMap();
		return findPath(start, finish, visited, maze);
	}
	private void p(String m){
		if (debug){
			System.out.println(m);
		}
	}
	boolean findPath(Integer[] start, Integer[] finish, HashMap<String, Integer[]> visited, String[][] maze){
		// if start == finish, return true
		if (Arrays.equals(start, finish)){
			return true;
		}
		int x = start[0];
		int y = start[1];
		String label = x+","+y;
		p("checking "+label);
		if ("$".equals(maze[x][y])){
			p("->hit a wall");
			return false;
		}
		Set<Integer[]> adj = getAdjacent(start, maze);
		p("--->has "+adj.size()+" exits");
		for ( Integer[] point: adj){
			String pt = point[0]+":"+point[1];
			if (visited.get(pt) != null){
				p("->seeing this point again, discarding ");
				continue;
			}
			visited.put(pt, point);
			// if (findPath(adjacent, finish, visited, maze)
			if (findPath(point, finish, visited, maze)) {
				p("->part of path");
				return true;
			} else {
				p("->backing out "+pt);
				
			}
		}
		p("->dead end");
		return false;
	}
	Set<Integer[]> getAdjacent(Integer[] point, String[][] maze ){
		HashSet<Integer[]> points = new HashSet<Integer[]>();
		// $ is a wall  . is a path
		//   $$$$$
		//  >..$.$
		//   $.$.$
		//   $....<
		//   $$$$$
		int x = point[0];
		int y = point[1];
		StringBuilder sb = new StringBuilder();
		//over
		if (y-1 >= 0 && ".".equals(maze[x][y-1]) ){
			Integer[] over = {x, y-1};
			appendPt(sb, x, y-1);
			points.add( over );
		}
		//under
		if (y+1 < maze[0].length && ".".equals(maze[x][y+1])){
			Integer[] under = {x, y+1};
			appendPt(sb, x, y+1);
			points.add( under );			
		}
		//left
		if ( x-1 >= 0 && ".".equals(maze[x-1][y])){
			Integer[] left = {x-1, y};
			appendPt(sb, x-1, y);
			points.add(left);
		}
		//right
		if ( x+1 < maze.length && ".".equals(maze[x+1][y])){
			Integer[] left = {x+1, y};
			appendPt(sb, x+1, y);
			points.add(left);
		}
		p(sb.toString());
		return points;
	}
	void appendPt(StringBuilder sb, int x, int y){
		sb.append(x); sb.append(':'); sb.append(y);sb.append('|');
	}
}
