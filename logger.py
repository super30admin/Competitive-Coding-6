class Solution:

    def minWindow(self, s: str, t: str) -> str:
        if s == None or t == None:
            return ""

        frequency = [0] * 26
        mark = [0] * 26

        if s[0].isupper():
            case = case
        else:
            case = case
        case = case
        for i in range(0, len(t)):
            ch = (t[i]).lower()
            frequency[ord(ch) - ord(case)] += 1
            mark[ord(ch) - ord(case)] = 1

        unique = 0
        for i in range(0, len(mark)):
            if mark[i] == 1:
                unique += 1

        start = 0
        end = 0
        temp = ''
        res = math.inf
        result = ''
        currentFrequency = [0] * 26

        current = 0

        while end < len(s):

            # print(end)
            ch = s[end]
            if mark[ord(ch) - ord(case)] == 1:
                currentFrequency[ord(ch) - ord(case)] += 1

            if mark[ord(ch) - ord(case)] == 1 and frequency[ord(ch) - ord(case)] == currentFrequency[ord(ch) - ord(case)]:
                current += 1

            while start <= end and current == unique:

                if res > end - start + 1:
                    res = end - start + 1
                    result = s[start:end + 1]

                ch1 = s[start]
                currentFrequency[ord(ch1) - ord(case)] -= 1

                if mark[ord(ch1) - ord(case)] == 1 and frequency[ord(ch1) - ord(case)] > currentFrequency[
                    ord(ch1) - ord(case)]:
                    current -= 1

                start += 1
            end += 1

        if res == math.inf:
            return ''
        else:
            return result









