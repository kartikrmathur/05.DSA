// Hard binary search problems: Book Allocation + Ship Within Days
class BinarySearchHard {
    public static void main(String[] args) {
        int books[] = {12,34,67,90};
        System.out.println(bookAllocation(books,2));
    }

    public static int bookAllocation(int books[], int students){
        if(books.length < students) {
            return -1;
        }
        // range: max element → sum of array
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i=0;i<books.length;i++){
            if(books[i]>start){
                start = books[i];
            }
            end = end + books[i];
        }
        int res = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(isAllocationPossible(books,mid,students)){
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return res;
    }

    static boolean isAllocationPossible(int books[], int maxPages, int students){
        int currentStudent = 1;
        int pages = 0;
        for(int i=0;i<books.length;i++){
            pages += books[i];
            if(pages>maxPages){
                currentStudent+=1;
                pages = books[i];
            }
            if(currentStudent > students) {
                return false;
            }
        }
        return true;
    }

    public static int shipWithinDays(int[] weights, int days) {
        // range: max element → sum of array
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i=0;i<weights.length;i++){
            if(weights[i]>start){
                start = weights[i];
            }
            end = end + weights[i];
        }
        int res = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(isShipmentPossible(weights,mid,days)){
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return res;
    }

    static boolean isShipmentPossible(int weights[], int maxCapacity, int days){
        int currentDay = 1;
        int capacity = 0;
        for(int i=0;i<weights.length;i++){
            capacity += weights[i];
            if(capacity>maxCapacity){
                currentDay+=1;
                capacity = weights[i];
            }
            if(currentDay > days) {
                return false;
            }
        }
        return true;
    }
}
