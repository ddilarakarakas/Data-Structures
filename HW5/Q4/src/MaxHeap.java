import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<AgeData> heap;
    public MaxHeap(){
        heap = new ArrayList<>();
    }

    /**
     * Add method.  It will first check if an AgeData object with that age exists in any index of the ArrayList.
     * If it exists, the number of people field of the AgeData object in that node will be increased 1.
     * Otherwise a new heap record with the AgeData object will be inserted.
     * @param data The object of inserted
     */
    public void add(AgeData data){
        boolean existControl = false;
        int exist = 0;
        for(int i=0;i<heap.size();i++){
            if(heap.get(i).getAge() == data.getAge()){
                existControl = true;
                exist = i;
            }
        }
        if(existControl)
            heap.get(exist).setAgeNumber(heap.get(exist).getAgeNumber() + 1);
        else
            heap.add(data);
        int current = heap.size()-1;
        int parent = (current-1) / 2;
        while(parent >= 0 && heap.get(parent).getAgeNumber() < heap.get(current).getAgeNumber()){
            swap(parent,current);
            current = parent;
            parent = (current - 1) / 2;
        }
    }
    /**
     * Removes target(if found) from heap
     * @param data The object deleted from the heap
     */
    public void remove(AgeData data){
        boolean existControl = false;
        boolean existAgePeopleControl = false;
        int exist = 0;
        for(int i=0;i<heap.size();i++){
            if(heap.get(i).getAge() == data.getAge()){
                existControl = true;
                exist = i;
                if(heap.get(i).getAgeNumber() > 1)
                    existAgePeopleControl = true;
            }
        }
        if(existControl){
            if(existAgePeopleControl){
                heap.get(exist).setAgeNumber(heap.get(exist).getAgeNumber() - 1);
                int parent = 0;
                int current = 2 * parent + 1;
                while(parent < heap.size() && heap.get(parent).getAgeNumber() < heap.get(current).getAgeNumber()){
                    swap(parent,current);
                    parent = current;
                    current = 2 * parent + 1;
                }
            }
            else{
                while(exist < heap.size()-1){
                    swap(exist,exist+1);
                    exist++;
                }
                heap.remove(heap.size()-1);
            }
        }
    }
    public AgeData find(int age){
        boolean existControl = false;
        int exist = 0;
        for(int i=0;i<heap.size();i++){
            if(heap.get(i).getAge() == age){
                existControl = true;
                exist = i;
            }
        }
        if(existControl)
            return heap.get(exist);
        else
            return null;
    }
    public String youngerThan(int num){
        StringBuilder sb = new StringBuilder();
        younger(sb,0,num);
        return sb.toString();
    }
    /**
     * youngerThan recursive
     */
    private void younger(StringBuilder sb, int current, int num){
        if(current == heap.size())
            return;
        else{
            if(heap.get(current).getAge() < num)
                sb.append(heap.get(current));
            younger(sb,++current,num);
        }
    }
    public String olderThan(int num){
        StringBuilder sb = new StringBuilder();
        older(sb,0,num);
        return sb.toString();
    }
    /**
     * olderThan recursive
     */
    private void older(StringBuilder sb, int current, int num){
        if(current == heap.size())
            return;
        else{
            if(heap.get(current).getAge() > num)
                sb.append(heap.get(current));
            older(sb,++current,num);
        }
    }
    private void swap(int parent,int child){
        AgeData tmp;
        tmp = heap.get(parent);
        heap.set(parent,heap.get(child));
        heap.set(child,tmp);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<heap.size();i++){
            sb.append(heap.get(i).toString());
        }
        return sb.toString();
    }
}
