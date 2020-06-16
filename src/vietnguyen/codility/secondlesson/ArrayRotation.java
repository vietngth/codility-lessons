package vietnguyen.codility.secondlesson;

public class ArrayRotation {
    public static int[] rotation(int arr[]) {
        int size = arr.length;
        int[] copyArr = new int[size];
        int lastValue = arr[size-1];
        int j=0;

        for (int i=1; i<size; i++) {
            copyArr[i] = arr[j++];
        }
        copyArr[0] = lastValue;
        return copyArr;
    }

    public static int[] rotations(int arr[], int rotations) {
        int size = arr.length;
        if (size == rotations) {
            return arr;
        }

        for (int i=0; i< rotations; i++) {
            arr = rotation(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int size = 5;
        int[] newArr = rotations(arr, 3);
        for(int i=0; i<size; i++) {
            System.out.print(newArr[i] + " ");
        }

        System.out.println();
        int a=3, b=5;
        System.out.println(a ^ b);
    }
}
