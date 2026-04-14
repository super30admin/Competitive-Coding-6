//
//  BeautifulArrangement.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/9/26.
//

class BeautifulArrangement {
    func countArrangement(_ n: Int) -> Int {
        var iSet = Set<Int>()
        var result = [[Int]]()
        var path = [Int]()
        var c = 0
        helper(n: n, iSet: &iSet, path: &path, result: &result, c: &c)
        print("result \(result)")
        print("c \(c)")
        return c
    }

    func helper(n: Int, iSet: inout Set<Int>, path: inout [Int], result: inout [[Int]], c: inout Int) {

        //base
        if (path.count == n) {
            c += 1
            result.append(path)
        }

        //logic
        for i in 1...n {
            let index = path.count + 1

            if ((index % i == 0 || i % index == 0) && !iSet.contains(i)) {
                iSet.insert(i)
                path.append(i)
                helper(n: n, iSet: &iSet, path: &path, result: &result, c: &c)
                iSet.remove(i)
                path.removeLast()
            }
        }
    }
}
