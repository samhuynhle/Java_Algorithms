class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return relativeSort(arr1, arr2);
    }

    public int[] relativeSort(int[] array1, int[] array2){
        if(array2.length == 0){
            return array1;
        }
        int[] occurances = new int[1001];
        for(int i = 0; i < array1.length; i++){
            occurances[array1[i]] ++;
        }
        int index = 0;
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < occurances[array2[i]]; j++){
                array1[index++] = array2[i];
            }
            occurances[array2[i]] = 0;
        }

        for(int i = 0; i < occurances.length; i++){
            if(occurances[i] == 0){
                continue;
            }
            for(int j = 0; j < occurances[i]; j++){
                array1[index++] = i;
            }
        }

        return array1;
    }
}