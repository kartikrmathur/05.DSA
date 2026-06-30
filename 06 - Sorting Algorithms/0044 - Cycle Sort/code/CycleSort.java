public class CycleSort {
    public static void main(String[] args) {
        int arr[] = {2,7,1,5,4,6,3};
        printArray(arr,"original array");
        cycleSort(arr);
        printArray(arr,"sorted array");
    }

    public static void swap(int arr[], int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int arr[], String message){
        System.out.println("Printing " + message);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void cycleSort(int arr[]){
        int n = arr.length;
        int index = 0;
        while(index<n){
            int element  = arr[index];
            int actualPos = element - 1;
            if(arr[index]<n && arr[index]!=arr[actualPos]){
                swap(arr,index,actualPos);
            } else {
                index++;
            }
        }
    }

    public static void cycleSort0ToN(int arr[]){
        int n = arr.length;
        int index = 0;
        while(index<n){
            int element  = arr[index];
            int actualPos = element;
            if(arr[index]<n && arr[index]!=arr[actualPos]){
                swap(arr,index,actualPos);
            } else {
                index++;
            }
        }
    }

    public static void cyclicSort(int arr[]){
        int n = arr.length;
        for(int cycles=0;cycles<n-1;cycles++){
            int pos = cycles;
            int item = arr[cycles];
            for(int i=cycles+1;i<n;i++){
                if(arr[i]<item){
                    pos++;
                }
            }
            if(pos==cycles){
                continue;
            }
            while(arr[pos]==item){
                pos++;
            }
            if(pos!=cycles){
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
            while(pos!=cycles){
                pos = cycles;
                for(int i=cycles+1;i<n;i++){
                    if(arr[i]<item){
                        pos++;
                    }
                }
                while(arr[pos]==item){
                    pos++;
                }
                if(item!=arr[pos]){
                    int temp = arr[pos];
                    arr[pos] = item;
                    item = temp;
                }
            }
        }
    }
}
