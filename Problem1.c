/* Problem Statement:
Verified on leetcode

784. Letter Case Permutation
Easy

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:

    S will be a string with length between 1 and 12.
    S will consist only of letters or digits.



 *
 * Time Complexity : O(2^n)
 * Space complexity : O(1) excluding result array 
 *
 */



/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

void letterCase_internal(int input_size, char *proc_str, int proc_str_size, char *left_string, int left_string_size, 
                          char **final_arr, int *final_arr_size) {
    char **fin_arr = final_arr;

    /* base condition */
    if (proc_str_size == input_size) {
        /* Make sure to NULL terminate the string */
        proc_str[proc_str_size] = '\0';     
        fin_arr[*final_arr_size] = (char *)malloc(proc_str_size + 1);
        strcpy(fin_arr[*final_arr_size], proc_str);
        *final_arr_size = *final_arr_size + 1;
    }

    /* Skip if we have already reached the end of string */
    if (left_string_size == 0) {
        return;
    }

    if (isalpha(*left_string)) {
        proc_str[proc_str_size] = tolower(*left_string);

        letterCase_internal(input_size, proc_str, proc_str_size + 1, left_string + 1,left_string_size - 1, 
                           final_arr, final_arr_size);
    
        proc_str[proc_str_size] = toupper(*left_string);
        letterCase_internal(input_size, proc_str, proc_str_size + 1, left_string + 1,left_string_size - 1, 
                           final_arr, final_arr_size);
    } else {
        proc_str[proc_str_size] = *left_string;
        letterCase_internal(input_size, proc_str, proc_str_size + 1, left_string + 1,left_string_size - 1, 
                           final_arr, final_arr_size);
    }
}

char ** letterCasePermutation(char * S, int* returnSize){
    
    char **final_arr = NULL;
    char *proc_str = NULL;
    *returnSize = 0;
    int inp_size = 0;
    
    /* validations */
    if (!S) {
        return final_arr;
    }
    #define MAX_SIZE 5000
    inp_size = strlen(S);
    
    final_arr = (char **)malloc(sizeof(char *) * MAX_SIZE);
    proc_str = (char *)malloc(inp_size + 1);
    
    letterCase_internal(strlen(S), proc_str, 0, S, strlen(S), final_arr, returnSize);
    free(proc_str);
    return final_arr;
}


*/
/* Execute on leetcode platform */


