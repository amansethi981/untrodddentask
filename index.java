import java.util.HashMap;

public class index{
    public static void precedence(String[] arr){
        HashMap<Character,Node>map=new HashMap<>();
        HashMap<Character,Integer> freqmap=new HashMap<>();
        String[] ans=new String[arr.length+1];

        for(int i=0;i<arr.length;i++){
            char first=arr[i].charAt(0);
            char second=arr[i].charAt(2);
            freqmap.put(first, freqmap.getOrDefault(first, 0) + 1);
            freqmap.put(second, freqmap.getOrDefault(second, 0) + 1);
            Node no=new Node(second);
            map.put(first, no);
        }
 
        for (HashMap.Entry<Character,Integer> entry : freqmap.entrySet())  
        { 
            if(entry.getValue()==1){
                char cc=entry.getKey();
                if(map.containsKey(cc))
                {
                   ans[0]=cc+"";
                }
                else{
                    ans[ans.length-1]=cc+"";
                }

            }
            
        }

        for(int i=0;i<ans.length-2;i++){
            Node n=map.get(ans[i].charAt(0));
            char next=n.next;
            ans[i+1]=next+"";
        }
        
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]);
        }

    }
    public static void main(String args[]){
        
        // String[] arr={"U>N","G>A","R>Y","H>U","N>G","A>R"};
       // String []arr={"I>F", "W>I", "S>W", "F>T"} ;
        //String []arr={"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"};
        String []arr={"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"}; 
        precedence(arr);
    }

    public static class Node{
       
        char next;
        Node(char next){
            this.next=next;
        }

    }
}