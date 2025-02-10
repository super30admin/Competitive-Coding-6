class BeautifulNumbers {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<result>> countArrangement(int n) {
        if(n == 0){
            return new ArrayList<>();
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            arr.add(i);
        }
        recurse(arr, new ArrayList<>());
        return result;
    }

    private void recurse(List<Integer> arr, List<Integer> list){

        if(list.size() == arr.size() - 1){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=1;i<arr.size(); i++) {
            if (!list.contains(arr.get(i))) {
                if(arr.get(i)%(list.size() +1) !=0 && (list.size() +1)%arr.get(i) !=0 ){
                    continue;
                }
                list.add(arr.get(i));
                recurse(arr, list);
                list.remove(list.size() - 1);
            }
        }

    }
}
