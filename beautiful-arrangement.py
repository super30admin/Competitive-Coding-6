# tc O(beautiful permutations count), sc O(n).
def get_beautiful_perms(start, curr_idx):
    # base case
    if curr_idx == n+1:
        count[0] += 1
        return
    
    # recursive case
    for idx in range(start, n+1):
        if perms[idx] % curr_idx == 0 or curr_idx % perms[idx] == 0:
            perms[start], perms[idx] = perms[idx], perms[start]
            get_beautiful_perms(start + 1, curr_idx+1)
            perms[start], perms[idx] = perms[idx], perms[start]

path = []
perms = [num for num in range(0, n+1)]
count = [0]
get_beautiful_perms(1, 1)
return count[0]