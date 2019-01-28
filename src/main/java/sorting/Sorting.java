package sorting;

public class Sorting {
	void bubblesort(int[] a) {
		//two loops, outer loop i runs n element times. inner loop j compares j and j+1 element 
		//if j is large then swap. if no swap in an inner loop then exit
		//time: Worst case - O(n^2). Best case O(n) if no swap, space: O(1) one swap temp variable.
		printHorizonal(a);
		for(int i=0;i<a.length;i++) {
			boolean isSwapped = false;
			for(int j=0; j<a.length-1;j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					isSwapped= true;
				}
			}
			if(!isSwapped) {
				break;
			}
		}
		printHorizonal(a);
	}
	
	void insertionsort(int[] a) {
		//two loops, outer loop gives a key it runs for n-1, inner loop runs for i to 0
		//checks if elements on left are greater than key
		//if element is greater then swap till element found is same or lesser.
		//inner loop breaks when first smaller element is found because element on further left are already sorted.
		//time: worst case O(n^2) Best case O(n) if almost sorted array, space: O(1) one swap temp variable
		printHorizonal(a);
		for(int i=1;i<a.length;i++) {
			int key = a[i];
			for(int j=i;j>0;j--) {
				if(a[j-1]>key) {
					int temp = a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}else {
					break;
				}
			}
		}
		printHorizonal(a);
	}
	
	void selectionsort(int[] a) {
		//two loops, outer loop select each element calls it a min, inner loop compares every element 
		//to find smaller than assumed min. if present the change min index. after inner loop we have
		//smallest from the remaining array and then swap if different from assumed min.
		//time: worst case O(n^2): best case O(n^2) space:O(1)
		printHorizonal(a);
		for(int i=0; i<a.length-1;i++) {
			int min = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[min]>a[j]) {
					min =j;
				}
			}
			if(min != i) {
				int temp =a[min];
				a[min]=a[i];
				a[i]=temp;
			}
		}
		printHorizonal(a);

	}
	
	void quicksort(int[] a, int lo, int hi) {
		//quick sort partitions array around a pivot, so that all elements on one side of pivot are
		//small than pivot and all elements on other side are larger.
		//after each iteration pivot gets its final position in the array and we follow same procedures
		//on two arrays (separated by pivot) recursively.
		//time: worst case O(n^2) depends on pivot pick Best case O(nlog(n)) , space: O(log n) for stack
		if(lo<hi) {
			int p = partition(a, lo, hi);
			quicksort(a, lo, p-1);
			quicksort(a,p+1, hi);
		}
	}
	
	int partition(int[] a, int l, int r) {
		int p = r;
		int pivot = a[p];
		int i = l;
		int j = r-1;
		while(i<=j) {
			while(a[i]<pivot) {
				i++;
			}
			while(j>=0 && a[j]>pivot) {
				j--;
			}
			
			if(i<j) {
				int temp = a[i];
				a[i]=a[j];
				a[j]=temp;
			}else {
				a[p]=a[i];
				a[i]=pivot;
				break;
			}
		}
		return i;
	}
	
	void heapsort(int[] a) {
		//create a max heap using heapify then remove top and heapify
		//build heap. Then remove top element and heapify recursively
		//time worst case O(nlogn) space O(log(n)) for stack
		int n = a.length;
		for(int i=n/2-1;i>=0;i--) {
			heapify(a, n, i);
		}
		for(int i=n-1;i>=0;i--) {
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			heapify(a, i, 0);
		}
	}
	
	void heapify(int[] a, int n, int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int max = i;
		
		if(l<n && a[max]<a[l]) {
			max = l;
		}
		if(r<n && a[max]<a[r]) {
			max = r;
		}
		if(max != i) {
			int temp = a[max];
			a[max]=a[i];
			a[i]=temp;
			heapify(a,n,max);
		}
	}
	
	int[] mergesort(int[] a) {
		//divide array in half recursively till it can no longer be divided
		//then merge them sorted recursively till we merge complete array
		//time worst case O(nlogn) space O((n)) for stack
		if(a.length == 1) {
			return a;
		}
		int mid = a.length/2;
		int[] l = new int[mid];
		int[] r = new int[a.length-mid];
		System.arraycopy(a, 0, l, 0, mid);
		System.arraycopy(a, mid, r, 0, a.length-mid);
		return merge(mergesort(l), mergesort(r));
	}
	
	int[] merge(int[] l, int[] r) {
		int[] result = new int[l.length+r.length];
		int i=0,j=0,k=0;
		while(i<l.length && j<r.length) {
			if(l[i]<r[j]) {
				result[k++]=l[i++];
			}else {
				result[k++]=r[j++];
			}
		}
		
		while(i<l.length) {
			result[k++]=l[i++];
		}
		
		while(j<r.length) {
			result[k++]=r[j++];
		}
		
		return result;	
	}
	public static void main(String[] args) {
		int[] myarray =  {25,12,15,11,89,24,19,20,12,10};
		//int[] myarray =  {25,12,35,21,89,24,10,11,12,15};
		Sorting obj = new Sorting();
		obj.printHorizonal(myarray);
		//obj.bubblesort(myarray);
		//obj.insertionsort(myarray);
		//obj.selectionsort(myarray);
		//obj.quicksort(myarray,0,myarray.length-1);
		//obj.heapsort(myarray);
		myarray = obj.mergesort(myarray);
		obj.printHorizonal(myarray);

	}
	
	void printHorizonal(int[] a) {
		for(int i : a) {
			System.out.print(i +" ");
		}
		System.out.println();
	}
}
