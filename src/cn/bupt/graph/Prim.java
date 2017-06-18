package cn.bupt.graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Prim {
	
	private int MAX_VERTIX=20;
	private Vertix vertixList[]=null;
	private int nvertix;
	private int ntree;
	private int adj[][]=null;
	private PriorityQueue<Endge> priorityQueue;
	
	public Prim(){
		vertixList=new Vertix[MAX_VERTIX];
		ntree=0;
		nvertix=0;
		adj=new int[MAX_VERTIX][MAX_VERTIX];
		for(int i=0;i<adj.length;i++){
			for(int j=0;j<adj[i].length;j++){
				adj[i][j]=Integer.MAX_VALUE;
			}
		}
		priorityQueue=new PriorityQueue<Endge>(MAX_VERTIX, new Comparator<Endge>() {

			@Override
			public int compare(Endge o1, Endge o2) {
				// TODO Auto-generated method stub
				return o1.distance-o2.distance;
			}
		});
	}
	
	public void addVertix(char label){
		vertixList[nvertix++]=new Vertix(label);
	}
	public void addEndge(int source,int dest,int distance){
		adj[source][dest]=distance;
		adj[dest][source]=distance;
	}
	
	public void prim(){
		int currentIndex=0;
		while(ntree<nvertix-1){
			vertixList[currentIndex].isIntree=true;
			ntree++;
			for(int i=0;i<nvertix;i++){
				if(i==currentIndex)
					continue;
				if(vertixList[i].isIntree)
					continue;
				if(adj[currentIndex][i]==Integer.MAX_VALUE)
					continue;
				int distance=adj[currentIndex][i];
				Endge tempEndge=getEndgeByDest(i);
				if(tempEndge!=null){
					if(distance<tempEndge.distance){
						priorityQueue.remove(tempEndge);
						priorityQueue.add(new Endge(currentIndex, i, distance));
					}
					
				}else{
					priorityQueue.add(new Endge(currentIndex, i, distance));
				}
				
				
			}
			if(priorityQueue.size()==0){
				System.out.println("GPATH NOT CONNECTED");
				return;
			}
			Endge minEndge=priorityQueue.poll();
			int dest=minEndge.destIndex;
			int source=minEndge.sourceIndex;
			currentIndex=dest;
			
			System.out.print(vertixList[source].label+"------>");
			System.out.print(vertixList[dest].label);
			System.out.println();
		}
	}
	
	public Endge getEndgeByDest(int dest){
		Iterator<Endge> it=priorityQueue.iterator();
		while(it.hasNext()){
			Endge endge=it.next();
			if(endge.destIndex==dest)
				return endge;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Prim prim=new Prim();
		prim.addVertix('A');
		prim.addVertix('B');
		prim.addVertix('C');
		prim.addVertix('D');
		prim.addVertix('E');
		prim.addVertix('F');
		prim.addEndge(0, 1, 6);
		prim.addEndge(0, 3, 4);
		prim.addEndge(1, 2, 10);
		prim.addEndge(1, 3, 7);
		prim.addEndge(1, 4, 7);
		prim.addEndge(2, 3, 8);
		prim.addEndge(2, 4, 5);
		prim.addEndge(2, 5, 6);
		prim.addEndge(3, 4, 12);
		prim.addEndge(4, 5, 7);
		prim.prim();
	}

}
