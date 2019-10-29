package Assignment6;

class ListNode{
    int val,key;
    ListNode next;
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class HashMap {
	final ListNode[] nodes = new ListNode[10000];	//since the number of operations will be in the range of [1, 10000].

	public static void main(String args[]){
		HashMap hashMap = new HashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(3, 3);
		System.out.println(hashMap.get(1));           
		System.out.println(hashMap.get(3));           
		hashMap.put(2, 10);        
		System.out.println(hashMap.get(2));         
		hashMap.remove(2);          
		System.out.println(hashMap.get(2));           
}
	
    public int hash(int key){
        return Integer.hashCode(key); 
    }

    public HashMap() {

    }

    public void put(int key, int value) {
        int hashNum = hash(key);
        ListNode head = nodes[hashNum];
        ListNode newMember = new ListNode(key, value);    

        if(head == null) {
            nodes[hashNum] = newMember;   
        }
        else{
            ListNode same = search(head, key);   
            if(same == null){
            	newMember.next = head;      
                nodes[hashNum] = newMember;
            }else
                same.val = value;    
        }

    }

    public ListNode search(ListNode node, int key){
        while(node != null){
            if(node.key == key){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int get(int key) {
        int hashNum = hash(key);
        if(nodes[hashNum] == null)        
            return -1;
        ListNode node = search(nodes[hashNum],key);   
        if(node == null) {
            return -1;
        }
        else {
            return node.val;
        }
    }

    public void remove(int key) {
        int hashnum = hash(key);
        if(nodes[hashnum] == null)      { 
            return;
        }
        ListNode cur = nodes[hashnum];
        ListNode pre = null;

        while(cur != null){
            if(cur.key == key){
                if(pre != null){
                    pre.next = cur.next;  
                }else{
                    nodes[hashnum] = cur.next;
                }
                break;
            }else{
                pre = cur;       
                cur = cur.next;
            }
        }
    }
	

}
